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
package edu.emory.cs.trie.autocomplete;

import edu.emory.cs.trie.Trie;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public abstract class Autocomplete<T> extends Trie<T> {
    private final int max;

    /**
     * @param dict_path the path to the dictionary file (e.g., "src/main/resources/dict.txt").
     * @param max       the maximum number of candidates to be retrieved.
     */
    public Autocomplete(String dict_path, int max) {
        this.max = max;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(dict_path)));
            int count = 0;
            String line;

            while ((line = reader.readLine()) != null) {
                put(line.trim(), null);
                count++;
            }

            System.out.printf("# of words added: %d\n", count);
        } catch (IOException ignored) {}
    }

    public int getMax() {
        return max;
    }

    /**
     * @param prefix the prefix of candidate words to return.
     * @return the list of candidate words for the specific prefix.
     */
    public abstract List<String> getCandidates(String prefix);

    /**
     * Memorize the specific candidate word for the specific prefix.
     * @param prefix    the prefix.
     * @param candidate the selected candidate for the prefix.
     */
    public abstract void pickCandidate(String prefix, String candidate);
}
