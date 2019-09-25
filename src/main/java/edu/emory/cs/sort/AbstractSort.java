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

import java.util.Comparator;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public abstract class AbstractSort<T extends Comparable<T>> {
    protected Comparator<T> comparator;
    protected long comparisons;
    protected long assignments;

    public AbstractSort(Comparator<T> comparator) {
        this.comparator = comparator;
        resetCounts();
    }

    /** @return the total number of comparisons performed by this sort. */
    public long getComparisonCount() {
        return comparisons;
    }

    /** @return the total number of assignments performed by this sort. */
    public long getAssignmentCount() {
        return assignments;
    }

    public void resetCounts() {
        comparisons = assignments = 0;
    }

    /**
     * @param array an array of comparable keys.
     * @param i the index of the first key.
     * @param j the index of the second key.
     * @return {@code array[i].compareTo(array[j])}
     */
    protected int compareTo(T[] array, int i, int j) {
        comparisons++;
        return comparator.compare(array[i], array[j]);
    }

    /**
     * {@code array[index] = value}
     * @param array an array of comparable keys.
     * @param index the index of the array to assign.
     * @param value the value to be assigned.
     */
    protected void assign(T[] array, int index, T value) {
        assignments++;
        array[index] = value;
    }

    /**
     * Swaps {@code array[i]} and {@code array[j]}.
     * @param array an array of comparable keys.
     * @param i the index of the first key.
     * @param j the index of the second key.
     */
    protected void swap(T[] array, int i, int j) {
        T t = array[i];
        assign(array, i, array[j]);
        assign(array, j, t);
    }

    /**
     * Sorts the array in ascending order.
     * @param array an array of comparable keys.
     */
    public void sort(T[] array) {
        sort(array, 0, array.length);
    }

    /**
     * Sorts the array[beginIndex:endIndex].
     * @param array an array of comparable keys.
     * @param beginIndex the index of the first key to be sorted (inclusive).
     * @param endIndex the index of the last key to be sorted (exclusive).
     */
    abstract public void sort(T[] array, int beginIndex, int endIndex);
}
