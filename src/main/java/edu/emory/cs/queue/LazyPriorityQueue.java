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
public class LazyPriorityQueue<T extends Comparable<T>> extends AbstractPriorityQueue<T> {
    private final List<T> keys;

    /** Initializes this as a maximum PQ. */
    public LazyPriorityQueue() {
        this(Comparator.naturalOrder());
    }

    /** @see AbstractPriorityQueue#AbstractPriorityQueue(Comparator). */
    public LazyPriorityQueue(Comparator<T> priority) {
        super(priority);
        keys = new ArrayList<>();
    }

    @Override
    public int size() {
        return keys.size();
    }

    /**
     * Appends a key to {@link #keys}.
     * @param key the key to be added.
     */
    @Override
    public void add(T key) {
        keys.add(key);
    }

    /**
     * Finds the key with the highest/lowest priority, and removes it from {@link #keys}.
     * @return the key with the highest/lowest priority if exists; otherwise, null.
     */
    @Override
    public T remove() {
        if (isEmpty()) return null;
        T max = Collections.max(keys, priority);
        keys.remove(max);
        return max;
    }
}
