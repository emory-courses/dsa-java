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
package edu.emory.cs.sort.comparison;

import java.util.Collections;
import java.util.Comparator;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class ShellSortKnuth<T extends Comparable<T>> extends ShellSort<T> {
    public ShellSortKnuth() {
        this(Comparator.naturalOrder());
    }

    public ShellSortKnuth(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    protected void populateSequence(int n) {
        n /= 3;

        for (int t = sequence.size() + 1; ; t++) {
            int h = (int) ((Math.pow(3, t) - 1) / 2);
            if (h <= n) sequence.add(h);
            else break;
        }
    }

    @Override
    protected int getSequenceStartIndex(int n) {
        int index = Collections.binarySearch(sequence, n / 3);
        if (index < 0) index = -(index + 1);
        if (index == sequence.size()) index--;
        return index;
    }
}
