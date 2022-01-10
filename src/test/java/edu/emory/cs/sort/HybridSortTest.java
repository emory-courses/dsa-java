/*
 * Copyright 2020 Emory University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.emory.cs.sort;

import edu.emory.cs.sort.hybrid.HybridSort;
import edu.emory.cs.sort.hybrid.HybridSortBaseline;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class HybridSortTest {
    private final Random rand = new Random();

    @Test
    public void testRobustness() {
        HybridSort<Integer> gold = new HybridSortBaseline<>();
        HybridSort<Integer> mine = new HybridSortBaseline<>();  // TODO: replace with your class

        Integer[][] input = {{0, 1, 2, 3}, {7, 6, 5, 4}, {0, 3, 1, 2}, {4, 7, 6, 5}, {9, 8, 11, 10}};
        testRobustness(input, gold, mine);

        for (int row = 10; row <= 20; row++)
            for (int col = 10; col <= 20; col++)
                for (int i = 0; i < 100; i++)
                    testRobustness(randomInput(row, col, 0.25), gold, mine);
    }

    void testRobustness(Integer[][] input, HybridSort<Integer> choi, HybridSort<Integer> mine) {
        Integer[] gold = choi.sort(copyOf(input));
        Integer[] auto = mine.sort(input);
        assertArrayEquals(gold, auto);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testSpeed() {
        HybridSort<Integer> gold = new HybridSortBaseline<>();
        HybridSort<Integer> mine = new HybridSortBaseline<>();  // TODO: replace with your class
        double ratio = 0.25;
        int row = 100, col;

        for (col = 100; col <= 1000; col += 100) {    // for (row = 100; row <= 1000; row += 100) {
            long[] time = testSpeed(row, col, ratio, gold, mine);
            StringJoiner join = new StringJoiner("\t");
            join.add(String.format("Row: %d, Col: %d, ratio: %4.2f", row, col, ratio));
            for (long t : time) join.add(Long.toString(t));
            System.out.println(join.toString());
        }
    }

    /**
     * @param row   the row size of the input.
     * @param col   the column size of the input.
     * @param ratio the ratio of the input to be shuffled (for the 3rd and 4th cases).
     */
    @SuppressWarnings("unchecked")
    long[] testSpeed(int row, int col, double ratio, HybridSort<Integer>... engine) {
        long[] time = new long[engine.length];
        final int warm = 10, iter = 1000;
        Integer[][] input, t;
        long st, et;

        for (int i = 0; i < warm; i++) {
            input = randomInput(row, col, ratio);

            for (HybridSort<Integer> anEngine : engine)
                anEngine.sort(copyOf(input));
        }

        for (int i = 0; i < iter; i++) {
            input = randomInput(row, col, ratio);

            for (int j = 0; j < engine.length; j++) {
                t = copyOf(input);
                st = System.currentTimeMillis();
                engine[j].sort(t);
                et = System.currentTimeMillis();
                time[j] += et - st;
            }
        }

        return time;
    }

    private Integer[][] copyOf(Integer[][] input) {
        Integer[][] copy = new Integer[input.length][];

        for (int i = 0; i < input.length; i++)
            copy[i] = Arrays.copyOf(input[i], input[i].length);

        return copy;
    }

    private Integer[][] randomInput(int row, int col, double ratio) {
        Integer[][] input = new Integer[row][];

        for (int i = 0; i < row; i++)
            input[i] = randomArray(col, ratio);

        return input;
    }

    private Integer[] randomArray(int size, double ratio) {
        return switch (rand.nextInt(5)) {
            case 0 -> randomArray(size, 0, Comparator.naturalOrder());
            case 1 -> randomArray(size, 0, Comparator.reverseOrder());
            case 2 -> randomArray(size, ratio, Comparator.naturalOrder());
            case 3 -> randomArray(size, ratio, Comparator.reverseOrder());
            case 4 -> randomArray(size, 0, null);
            default -> throw new IllegalArgumentException();
        };
    }

    private Integer[] randomArray(int size, double ratio, Comparator<Integer> comparator) {
        Integer[] array = new Integer[size];
        int shuffle = (int)(size * ratio);

        for (int i = 0; i < size; i++) array[i] = rand.nextInt();
        if (comparator != null) Arrays.sort(array, comparator);

        for (int i = 0; i < shuffle; i++)
            swap(array, rand.nextInt(array.length), rand.nextInt(array.length));

        return array;
    }

    private void swap(Integer[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}