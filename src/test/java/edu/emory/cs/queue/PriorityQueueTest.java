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
package edu.emory.cs.queue;

import edu.emory.cs.utils.Utils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class PriorityQueueTest {
    @Test
    public void testAccuracy() {
        List<Integer> keys = List.of(4, 1, 3, 2, 5, 6, 8, 3, 4, 7, 5, 9, 7);
        Comparator<Integer> natural = Comparator.naturalOrder();
        Comparator<Integer> reverse = Comparator.reverseOrder();

        testAccuracy(new LazyPriorityQueue<>(), reverse, new ArrayList<>(keys));
        testAccuracy(new EagerPriorityQueue<>(), reverse, new ArrayList<>(keys));
        testAccuracy(new BinaryHeap<>(), reverse, new ArrayList<>(keys));

        testAccuracy(new LazyPriorityQueue<Integer>(reverse), natural, new ArrayList<>(keys));
        testAccuracy(new EagerPriorityQueue<Integer>(reverse), natural, new ArrayList<>(keys));
        testAccuracy(new BinaryHeap<Integer>(reverse), natural, new ArrayList<>(keys));
    }

    /**
     * @param q    a priority queue.
     * @param c    a comparator used for sorting.
     * @param keys a list of comparable keys.
     */
    private <T extends Comparable<T>> void testAccuracy(AbstractPriorityQueue<T> q, Comparator<T> c, List<T> keys) {
        keys.forEach(q::add);
        keys.sort(c);
        keys.forEach(key -> assertEquals(key, q.remove()));
    }

    @Test
    public void testSpeed() {
        testSpeed(new LazyPriorityQueue<>(), new EagerPriorityQueue<>(), new BinaryHeap<>());
    }

    @SafeVarargs
    private void testSpeed(AbstractPriorityQueue<Integer>... qs) {
        for (int size = 1000; size <= 10000; size += 1000) {
            // JVM warmup
            benchmark(qs, 10, size);
            // benchmark all priority queues with the same keys
            Time[] times = benchmark(qs, 1000, size);

            StringJoiner joiner = new StringJoiner("\t");
            joiner.add(Integer.toString(size));
            joiner.add(Arrays.stream(times).map(t -> Long.toString(t.add)).collect(Collectors.joining("\t")));
            joiner.add(Arrays.stream(times).map(t -> Long.toString(t.remove)).collect(Collectors.joining("\t")));
            System.out.println(joiner.toString());
        }
    }

    private class Time {
        long add = 0;
        long remove = 0;
    }

    private Time[] benchmark(AbstractPriorityQueue<Integer>[] qs, int iter, int size) {
        Time[] ts = Stream.generate(Time::new).limit(qs.length).toArray(Time[]::new);
        Random rand = new Random();

        for (int i = 0; i < iter; i++) {
            int[] keys = Utils.getRandomIntArray(rand, size);

            for (int j = 0; j < qs.length; j++)
                addRuntime(qs[j], ts[j], keys);
        }

        return ts;
    }

    private void addRuntime(AbstractPriorityQueue<Integer> q, Time t, int[] keys) {
        long st, et;

        // runtime for q.add()
        st = System.currentTimeMillis();
        Arrays.stream(keys).forEach(q::add);
        et = System.currentTimeMillis();
        t.add += et - st;

        // runtime for q.remove()
        st = System.currentTimeMillis();
        while (!q.isEmpty()) q.remove();
        et = System.currentTimeMillis();
        t.remove += et - st;
    }

//    @Test
//    public void testNaryHeap() {
//        List<Integer> keys = List.of(4, 1, 3, 2, 5, 6, 8, 3, 4, 7, 5, 9, 7);
//        testAccuracy(new NaryHeap<>(3), Comparator.reverseOrder(), new ArrayList<>(keys));
//        testAccuracy(new NaryHeap<Integer>(3, Comparator.reverseOrder()), Comparator.naturalOrder(), new ArrayList<>(keys));
//        testSpeed(new NaryHeap<>(2), new NaryHeap<>(3), new NaryHeap<>(4), new NaryHeap<>(5), new NaryHeap<>(6));
//    }
}
