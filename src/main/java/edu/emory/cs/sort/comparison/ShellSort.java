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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public abstract class ShellSort<T extends Comparable<T>> extends InsertionSort<T> {
    protected List<Integer> sequence;

    /**
     * @param n the max-number of items in the list to be sorted.
     */
    public ShellSort(int n) {
        this(Comparator.naturalOrder(), n);
    }

    /**
     * @param n the expected size of the list to be sorted.
     */
    public ShellSort(Comparator<T> comparator, int n) {
        super(comparator);
        sequence = new ArrayList<>();
        populateSequence(n);
    }

    @Override
    public void sort(T[] array, int beginIndex, int endIndex) {
        int n = endIndex - beginIndex;
        populateSequence(n);

        for (int i = getSequenceStartIndex(n); i >= 0; i--)
            sort(array, beginIndex, endIndex, sequence.get(i));
    }

    /**
     * Populates the gap sequence with respect to the size of the list.
     * @param n the size of the list to be sorted.
     */
    protected abstract void populateSequence(int n);

    /**
     * @param n the size of the list to be sorted.
     * @return the starting index of the sequence with respect to the size of the list.
     */
    protected abstract int getSequenceStartIndex(int n);
}
