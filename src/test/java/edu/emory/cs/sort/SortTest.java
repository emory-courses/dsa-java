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

import edu.emory.cs.sort.comparison.HeapSort;
import edu.emory.cs.sort.comparison.InsertionSort;
import edu.emory.cs.sort.comparison.SelectionSort;
import edu.emory.cs.sort.comparison.ShellSortKnuth;
import edu.emory.cs.sort.distribution.IntegerBucketSort;
import edu.emory.cs.sort.distribution.LSDRadixSort;
import edu.emory.cs.sort.divide_conquer.IntroSort;
import edu.emory.cs.sort.divide_conquer.MergeSort;
import edu.emory.cs.sort.divide_conquer.QuickSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class SortTest {
    @Test
    public void testRobustness() {

        testRobustness(new SelectionSort<>());
        testRobustness(new InsertionSort<>());
        testRobustness(new HeapSort<>());
        testRobustness(new ShellSortKnuth<>());

        testRobustness(new MergeSort<>());
        testRobustness(new QuickSort<>());
        testRobustness(new IntroSort<>(new HeapSort<Integer>()));
        testRobustness(new IntroSort<>(new ShellSortKnuth<Integer>()));

        testRobustness(new IntegerBucketSort(0, 10000));
        testRobustness(new LSDRadixSort());
    }

    void testRobustness(AbstractSort<Integer> engine) {
        final int iter = 100;
        final int size = 1000;
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
    public void testRuntime() {
        testRuntime(new HeapSort<>(), new ShellSortKnuth<>(), new SelectionSort<>(), new InsertionSort<>());
//    testRuntime(new HeapSort<>(), new ShellSortKnuth<>(), new MergeSort<>(), new QuickSort<>(), new IntroSort<>(new HeapSort<Integer>()), new IntroSort<>(new ShellSortKnuth<Integer>()));
//    testRuntime(new HeapSort<>(), new ShellSortKnuth<>(), new MergeSort<>(), new QuickSort<>(), new IntegerBucketSort(0, 10000), new LSDRadixSort());
    }

    @SafeVarargs
    final void testRuntime(AbstractSort<Integer>... engines) {
        final int max_size = 10000;
        final int init_size = 1000;
        final int inc = 1000;
        final int iter = 1000;
        final InputNature nature = InputNature.RANDOM;

        for (int size = init_size; size <= max_size; size += inc) {
            // JVM warmup
            benchmark(engines, 10, size, nature);
            // benchmark all soring algorithms with the same keys
            Time[] times = benchmark(engines, iter, size, nature);

            StringJoiner joiner = new StringJoiner("\t");
            joiner.add(Integer.toString(size));
            joiner.add(Arrays.stream(times).map(t -> Long.toString(t.millis)).collect(Collectors.joining("\t")));
            joiner.add(Arrays.stream(times).map(t -> Long.toString(t.comparisons)).collect(Collectors.joining("\t")));
            joiner.add(Arrays.stream(times).map(t -> Long.toString(t.assignments)).collect(Collectors.joining("\t")));
            System.out.println(joiner.toString());
        }
    }

    Time[] benchmark(AbstractSort<Integer>[] engines, int iter, int size, InputNature nature) {
        Time[] ts = Stream.generate(Time::new).limit(engines.length).toArray(Time[]::new);
        Random rand = new Random();

        for (int i = 0; i < iter; i++) {
            Integer[] keys = Stream.generate(() -> rand.nextInt(size)).limit(size).toArray(Integer[]::new);
            switch (nature) {
                case ASCENDING -> Arrays.sort(keys);
                case DESCENDING -> Arrays.sort(keys, Comparator.reverseOrder());
            }

            for (int j = 0; j < engines.length; j++)
                addRuntime(engines[j], ts[j], Arrays.copyOf(keys, size));
        }

        return ts;
    }

    static class Time {
        long comparisons = 0;
        long assignments = 0;
        long millis = 0;
    }

    void addRuntime(AbstractSort<Integer> engine, Time t, Integer[] keys) {
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
}
