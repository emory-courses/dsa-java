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
package edu.emory.cs.sort.comparison;

import edu.emory.cs.sort.AbstractSort;

import java.util.Comparator;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class HeapSort<T extends Comparable<T>> extends AbstractSort<T> {
    public HeapSort() {
        this(Comparator.naturalOrder());
    }

    public HeapSort(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public void sort(T[] array, int beginIndex, int endIndex) {
        // heapify all elements
        for (int k = getParentIndex(beginIndex, endIndex); k >= beginIndex; k--)
            sink(array, k, beginIndex, endIndex);

        // swap the endIndex element with the root element and sink it
        while (endIndex > beginIndex + 1) {
            swap(array, beginIndex, --endIndex);
            sink(array, beginIndex, beginIndex, endIndex);
        }
    }

    private void sink(T[] array, int k, int beginIndex, int endIndex) {
        for (int i = getLeftChildIndex(beginIndex, k); i < endIndex; k = i, i = getLeftChildIndex(beginIndex, k)) {
            if (i + 1 < endIndex && compareTo(array, i, i + 1) < 0) i++;
            if (compareTo(array, k, i) >= 0) break;
            swap(array, k, i);
        }
    }

    private int getParentIndex(int beginIndex, int k) {
        return beginIndex + (k - beginIndex) / 2 - 1;
    }

    private int getLeftChildIndex(int beginIndex, int k) {
        return beginIndex + 2 * (k - beginIndex) + 1;
    }
}
