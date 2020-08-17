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

import java.util.Comparator;

/** @author Jinho D. Choi */
public abstract class AbstractPriorityQueue<T extends Comparable<T>> {
    protected final Comparator<T> priority;

    /**
     * Initializes this PQ as either a maximum or minimum PQ.
     * @param priority if {@link Comparator#naturalOrder()}, this is a max PQ;
     *                 if {@link Comparator#reverseOrder()}, this is a min PQ.
     */
    public AbstractPriorityQueue(Comparator<T> priority) {
        this.priority = priority;
    }

    /**
     * Adds a comparable key to this PQ.
     * @param key the key to be added.
     */
    abstract public void add(T key);

    /**
     * Removes the key with the highest/lowest priority if exists.
     * @return the key with the highest/lowest priority if exists; otherwise, null.
     */
    abstract public T remove();

    /** @return the size of this PQ. */
    abstract public int size();

    /** @return true if this PQ is empty; otherwise, false. */
    public boolean isEmpty() {
        return size() == 0;
    }
}


