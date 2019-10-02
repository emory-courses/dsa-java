/*
 * Copyright 2014, Emory University
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

import edu.emory.cs.sort.comparison.HeapSort;
import edu.emory.cs.sort.comparison.InsertionSort;
import edu.emory.cs.sort.comparison.SelectionSort;
import edu.emory.cs.sort.comparison.ShellSortKnuth;
import edu.emory.cs.sort.distribution.IntegerBucketSort;
import edu.emory.cs.sort.distribution.LSDRadixSort;
import edu.emory.cs.sort.divide_conquer.IntroSort;
import edu.emory.cs.sort.divide_conquer.MergeSort;
import edu.emory.cs.sort.divide_conquer.QuickSort;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class SortTest {
    @Test
    public void testAccuracy() {
        final int iter = 100;
        final int size = 1000;

        testAccuracy(iter, size, new SelectionSort<>());
        testAccuracy(iter, size, new InsertionSort<>());
        testAccuracy(iter, size, new HeapSort<>());
        testAccuracy(iter, size, new ShellSortKnuth<>());

        testAccuracy(iter, size, new MergeSort<>());
        testAccuracy(iter, size, new QuickSort<>());
        testAccuracy(iter, size, new IntroSort<>(new HeapSort<Integer>()));
        testAccuracy(iter, size, new IntroSort<>(new ShellSortKnuth<Integer>()));

        testAccuracy(iter, size, new IntegerBucketSort(0, size));
        testAccuracy(iter, size, new LSDRadixSort());
    }

    private void testAccuracy(final int iter, final int size, AbstractSort<Integer> engine) {
        final Random rand = new Random();
        Integer[] original, sorted;

        for (int i = 0; i < iter; i++) {
            original = Stream.generate(() -> rand.nextInt(size)).limit(size).toArray(Integer[]::new);
            sorted = Arrays.copyOf(original, size);

            engine.sort(original);
            Arrays.sort(sorted);

            assertArrayEquals(original, sorted);
        }
    }

    @Test
    public void testSpeed() {
        final int max_size = 10000;
//      testSpeed(max_size, new HeapSort<>(), new ShellSortKnuth<>(), new SelectionSort<>(), new InsertionSort<>());
//      testSpeed(max_size, new HeapSort<>(), new ShellSortKnuth<>(), new MergeSort<>(), new QuickSort<>(), new IntroSort<>(new HeapSort<Integer>()), new IntroSort<>(new ShellSortKnuth<Integer>()));
        testSpeed(max_size, new HeapSort<>(), new ShellSortKnuth<>(), new MergeSort<>(), new QuickSort<>(), new IntegerBucketSort(0, max_size), new LSDRadixSort());
    }

    @SafeVarargs
    private void testSpeed(final int max_size, AbstractSort<Integer>... engines) {
        final int init_size = 1000;
        final int inc = 1000;
        final int iter = 1000;

        for (int size = init_size; size <= max_size; size += inc) {
            // JVM warmup
            benchmark(engines, 10, size);
            // benchmark all soring algorithms with the same keys
            Time[] times = benchmark(engines, iter, size);

            StringJoiner joiner = new StringJoiner("\t");
            joiner.add(Integer.toString(size));
            joiner.add(Arrays.stream(times).map(t -> Long.toString(t.millis)).collect(Collectors.joining("\t")));
            joiner.add(Arrays.stream(times).map(t -> Long.toString(t.comparisons)).collect(Collectors.joining("\t")));
            joiner.add(Arrays.stream(times).map(t -> Long.toString(t.assignments)).collect(Collectors.joining("\t")));
            System.out.println(joiner.toString());
        }
    }

    private class Time {
        long comparisons = 0;
        long assignments = 0;
        long millis = 0;
    }

    private Time[] benchmark(AbstractSort<Integer>[] engines, int iter, int size) {
        Time[] ts = Stream.generate(Time::new).limit(engines.length).toArray(Time[]::new);
        Random rand = new Random();

        for (int i = 0; i < iter; i++) {
            Integer[] keys = Stream.generate(() -> rand.nextInt(size)).limit(size).toArray(Integer[]::new);
//          Arrays.sort(keys);
//          Arrays.sort(keys, Comparator.reverseOrder());

            for (int j = 0; j < engines.length; j++)
                addRuntime(engines[j], ts[j], Arrays.copyOf(keys, size));
        }

        return ts;
    }

    private void addRuntime(AbstractSort<Integer> engine, Time t, Integer[] keys) {
        engine.resetCounts();

        // speed
        long st = System.currentTimeMillis();
        engine.sort(keys);
        long et = System.currentTimeMillis();
        t.millis += et - st;

        // operations
        t.assignments += engine.getAssignmentCount();
        t.comparisons += engine.getComparisonCount();
    }

//    @Test
//    public void testOtherSorts() {
//        final int iter = 100;
//        final int size = 100;
//
//        testAccuracy(iter, size, new ShellSortHibbard<>());
//        testAccuracy(iter, size, new ShellSortPratt<>());
//        testAccuracy(iter, size, new MSDRadixSort());
//        testSpeed(new ShellSortKnuth<>(), new ShellSortHibbard<>(), new ShellSortPratt<>());
//        testSpeed(max_size, new QuickSort<>(), new LSDRadixSort(), new MSDRadixSort());
//    }
}
