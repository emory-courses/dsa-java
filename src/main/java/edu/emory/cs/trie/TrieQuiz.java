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
