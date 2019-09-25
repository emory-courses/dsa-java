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
package edu.emory.cs.sort.divide_conquer;

import edu.emory.cs.sort.AbstractSort;

import java.util.Comparator;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSort<T> {
    public QuickSort() {
        this(Comparator.naturalOrder());
    }

    public QuickSort(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public void sort(T[] array, int beginIndex, int endIndex) {
        // at least one key in the range
        if (beginIndex >= endIndex) return;

        int pivotIndex = partition(array, beginIndex, endIndex);
        // sort left partition
        sort(array, beginIndex, pivotIndex);
        // sort right partition
        sort(array, pivotIndex + 1, endIndex);
    }

    protected int partition(T[] array, int beginIndex, int endIndex) {
        int fst = beginIndex, snd = endIndex;

        while (true) {
            // Find where endIndex > fst > pivot
            while (++fst < endIndex && compareTo(array, beginIndex, fst) >= 0);
            // Find where beginIndex < snd < pivot
            while (--snd > beginIndex && compareTo(array, beginIndex, snd) <= 0);
            // pointers crossed
            if (fst >= snd) break;
            // exchange
            swap(array, fst, snd);
        }

        swap(array, beginIndex, snd);
        return snd;
    }
}
