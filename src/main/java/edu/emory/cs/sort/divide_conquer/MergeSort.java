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
package edu.emory.cs.sort.divide_conquer;

import edu.emory.cs.sort.AbstractSort;
import edu.emory.cs.utils.Utils;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSort<T> {
    private T[] temp;

    public MergeSort() {
        this(Comparator.naturalOrder());
    }

    public MergeSort(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void sort(T[] array, int beginIndex, int endIndex) {
        if (temp == null || temp.length < array.length)
            temp = (T[])Array.newInstance(array[0].getClass(), array.length);
        sort(array, temp, beginIndex, endIndex);
    }

    /**
     * @param input the input array.
     * @param copy the array to hold the copy of the input array.
     * @param beginIndex the beginning index of the 1st half (inclusive).
     * @param endIndex the ending index of the 2nd half (exclusive).
     */
    protected void sort(T[] input, T[] copy, int beginIndex, int endIndex) {
        if (beginIndex + 1 >= endIndex) return;
        int middleIndex = Utils.getMiddleIndex(beginIndex, endIndex);

        sort(input, copy, beginIndex, middleIndex);
        sort(input, copy, middleIndex, endIndex);
        merge(input, copy, beginIndex, middleIndex, endIndex);
    }

    /**
     * @param input the input array.
     * @param copy the array to hold the copy of the input array.
     * @param beginIndex  the beginning index of the 1st half (inclusive).
     * @param middleIndex the ending index of the 1st half (exclusive).
     * @param endIndex    the ending index of the 2nd half (exclusive).
     */
    protected void merge(T[] input, T[] copy, int beginIndex, int middleIndex, int endIndex) {
        int fst = beginIndex, snd = middleIndex, n = endIndex - beginIndex;
        System.arraycopy(input, beginIndex, copy, beginIndex, n);
        assignments += n;

        for (int k = beginIndex; k < endIndex; k++) {
            if (fst >= middleIndex)                    // no key left in the 1st half
                assign(input, k, copy[snd++]);
            else if (snd >= endIndex)                  // no key left in the 2nd half
                assign(input, k, copy[fst++]);
            else if (compareTo(copy, fst, snd) < 0)    // 1st key < 2nd key
                assign(input, k, copy[fst++]);
            else
                assign(input, k, copy[snd++]);
        }
    }
}
