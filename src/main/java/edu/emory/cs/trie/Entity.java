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
package edu.emory.cs.trie;

import java.util.Comparator;

/** @author Jinho D. Choi */
public class Entity {
    public int begin_index;
    public int end_index;
    public int country_id;

    /**
     * @param begin_index the offset of the first character (inclusive).
     * @param end_index the offset of the last character (exclusive).
     * @param country_id the unique country ID.
     */
    public Entity(int begin_index, int end_index, int country_id) {
        this.begin_index = begin_index;
        this.end_index = end_index;
        this.country_id = country_id;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d, %d)", begin_index, end_index, country_id);
    }
}
