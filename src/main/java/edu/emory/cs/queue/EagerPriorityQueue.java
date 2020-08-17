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
public class EagerPriorityQueue<T extends Comparable<T>> extends AbstractPriorityQueue<T> {
    private final List<T> keys;

    public EagerPriorityQueue() {
        this(Comparator.naturalOrder());
    }

    public EagerPriorityQueue(Comparator<T> priority) {
        super(priority);
        keys = new ArrayList<>();
    }

    @Override
    public int size() {
        return keys.size();
    }

    /**
     * Adds a key to {@link #keys} by the priority.
     * @param key the key to be added.
     */
    @Override
    public void add(T key) {
        // binary search (if not found, index < 0)
        int index = Collections.binarySearch(keys, key, priority);
        // if not found, the appropriate index is {@code -(index +1)}
        if (index < 0) index = -(index + 1);
        keys.add(index, key);
    }

    /**
     * Removes the last key in {@link #keys}.
     * @return the key with the highest priority if exists; otherwise, {@code null}.
     */
    @Override
    public T remove() {
        return isEmpty() ? null : keys.remove(keys.size() - 1);
    }
}
