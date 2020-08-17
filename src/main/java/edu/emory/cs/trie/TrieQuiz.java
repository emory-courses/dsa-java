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

import java.util.ArrayList;
import java.util.List;

public class TrieQuiz {
    class Entity {
        int begin_index;
        int end_index;
        int country_id;

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
    }

    /**
     * @param T the trie containing all country names as keys and their unique IDs as values
     *          (e.g., T.get("United States") -> 0, T.get("South Korea") -> 1).
     * @param input the input string in plain text
     *              (e.g., "I was born in South Korea and raised in the United States").
     * @return the list of entities (e.g., [Entity(14, 25, 1), Entity(44, 57, 0)]).
     */
    List<Entity> get_entities(Trie<Integer> T, String input) {
        List<Entity> entities = new ArrayList<>();
        // TODO: to be filled.

        return entities;
    }
}
