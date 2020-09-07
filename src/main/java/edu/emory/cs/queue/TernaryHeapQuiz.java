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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/** @author Jinho D. Choi */
public class TernaryHeapQuiz<T extends Comparable<T>> extends AbstractPriorityQueue<T> {
    private final List<T> keys;

    public TernaryHeapQuiz() {
        this(Comparator.naturalOrder());
    }

    public TernaryHeapQuiz(Comparator<T> priority) {
        super(priority);
        keys = new ArrayList<>();
        // TODO: to be updated
    }

    @Override
    public void add(T key) {
        // TODO: to be updated
    }

    @Override
    public T remove() {
        // TODO: to be updated
        return null;
    }

    @Override
    public int size() {
        // TODO: to be updated
        return 0;
    }
}
