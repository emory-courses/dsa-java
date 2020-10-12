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

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class Trie<T> {
    private final TrieNode<T> root;

    public Trie() {
        root = new TrieNode<>(null, (char)0);
    }

    public TrieNode<T> getRoot() {
        return root;
    }

    /** @return the node with the specific key if exists; otherwise, {@code null}. */
    public TrieNode<T> find(String key) {
        TrieNode<T> node = root;

        for (char c : key.toCharArray()) {
            node = node.getChild(c);
            if (node == null) return null;
        }

        return node;
    }

    public T get(String key) {
        TrieNode<T> node = find(key);
        return (node != null && node.isEndState()) ? node.getValue() : null;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    /** @return the previously inserted value for the specific key if exists; otherwise, {@code null}. */
    public T put(String key, T value) {
        TrieNode<T> node = root;

        for (char c : key.toCharArray())
            node = node.addChild(c);

        node.setEndState(true);
        return node.setValue(value);
    }

    /** @return {@code true} if a node with the specific key if exists; otherwise, {@code false}. */
    public boolean remove(String key) {
        TrieNode<T> node = find(key);

        if (node == null || !node.isEndState())
            return false;

        if (node.hasChildren()) {
            node.setEndState(false);
            return true;
        }

        TrieNode<T> parent = node.getParent();

        while (parent != null) {
            parent.removeChild(node.getKey());

            if (parent.hasChildren() || parent.isEndState())
                break;
            else {
                node = parent;
                parent = parent.getParent();
            }
        }

        return true;
    }
}
