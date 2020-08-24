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
package edu.emory.cs.queue;

import org.junit.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class PriorityQueueTest {
    @Test
    public void testRobustness() {
        List<Integer> keys = List.of(4, 1, 3, 2, 5, 6, 8, 3, 4, 7, 5, 9, 7);
        Comparator<Integer> natural = Comparator.naturalOrder();
        Comparator<Integer> reverse = Comparator.reverseOrder();

        testRobustnessAux(new LazyPriorityQueue<>(), keys, reverse);
        testRobustnessAux(new EagerPriorityQueue<>(), keys, reverse);
        testRobustnessAux(new BinaryHeap<>(), keys, reverse);

        testRobustnessAux(new LazyPriorityQueue<>(reverse), keys, natural);
        testRobustnessAux(new EagerPriorityQueue<>(reverse), keys, natural);
        testRobustnessAux(new BinaryHeap<>(reverse), keys, natural);
    }

    /**
     * @param pq   a priority queue.
     * @param keys a list of comparable keys.
     * @param comp a comparator used for sorting.
     */
    <T extends Comparable<T>> void testRobustnessAux(AbstractPriorityQueue<T> pq, List<T> keys, Comparator<T> comp) {
        keys.forEach(pq::add);
        keys = keys.stream().sorted(comp).collect(Collectors.toList());
        keys.forEach(key -> assertEquals(key, pq.remove()));
    }

    @Test
    public void testRuntime() {
        testRuntimeAux(new LazyPriorityQueue<>(), new EagerPriorityQueue<>(), new BinaryHeap<>());
    }

    @SafeVarargs
    final <T extends Comparable<T>> void testRuntimeAux(AbstractPriorityQueue<Integer>... queues) {
        final int BEGIN_SIZE = 100;
        final int END_SIZE = 1000;
        final int INC = 100;
        Random rand = new Random();

        for (int size = BEGIN_SIZE; size <= END_SIZE; size += INC) {
            // JVM warm-up
            benchmark(queues, size, 10, rand::nextInt);
            // benchmark all priority queues with the same keys
            Time[] times = benchmark(queues, size, 1000, rand::nextInt);

            StringJoiner joiner = new StringJoiner("\t");
            joiner.add(Integer.toString(size));
            joiner.add(Arrays.stream(times).map(t -> Long.toString(t.add)).collect(Collectors.joining("\t")));
            joiner.add(Arrays.stream(times).map(t -> Long.toString(t.remove)).collect(Collectors.joining("\t")));
            System.out.println(joiner.toString());
        }
    }

    <T extends Comparable<T>> Time[] benchmark(AbstractPriorityQueue<T>[] queues, int size, int iter, Supplier<T> sup) {
        Time[] times = Stream.generate(Time::new).limit(queues.length).toArray(Time[]::new);

        for (int i = 0; i < iter; i++) {
            List<T> keys = Stream.generate(sup).limit(size).collect(Collectors.toList());
            for (int j = 0; j < queues.length; j++)
                addRuntime(queues[j], times[j], keys);
        }

        return times;
    }

    static class Time {
        long add = 0;
        long remove = 0;
    }

    <T extends Comparable<T>> void addRuntime(AbstractPriorityQueue<T> queue, Time time, List<T> keys) {
        long st, et;

        // runtime for add()
        st = System.currentTimeMillis();
        keys.forEach(queue::add);
        et = System.currentTimeMillis();
        time.add += et - st;

        // runtime for remove()
        st = System.currentTimeMillis();
        while (!queue.isEmpty()) queue.remove();
        et = System.currentTimeMillis();
        time.remove += et - st;
    }

//    @Test
//    public void testNaryHeap() {
//        List<Integer> keys = List.of(4, 1, 3, 2, 5, 6, 8, 3, 4, 7, 5, 9, 7);
//        testAccuracy(new NaryHeap<>(3), Comparator.reverseOrder(), new ArrayList<>(keys));
//        testAccuracy(new NaryHeap<Integer>(3, Comparator.reverseOrder()), Comparator.naturalOrder(), new ArrayList<>(keys));
//        testSpeed(new NaryHeap<>(2), new NaryHeap<>(3), new NaryHeap<>(4), new NaryHeap<>(5), new NaryHeap<>(6));
//    }
}


//        100	1	13	4	25	2	12
//        200	2	20	5	45	0	28
//        300	0	43	14	91	4	19
//        400	2	39	12	164	2	47
//        500	8	52	18	228	8	60
//        600	11	70	14	315	8	83
//        700	4	86	21	420	3	104
//        800	8	86	20	567	6	105
//        900	7	111	29	693	7	148
//        1000	5	103	42	862	5	146