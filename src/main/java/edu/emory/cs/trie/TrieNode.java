/*
 * Copyright 2014, Emory University
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

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class TrieNode<T> {
    private Map<Character, TrieNode<T>> children;
    private TrieNode<T> parent;
    private boolean end_state;
    private char key;
    private T value;

    public TrieNode(TrieNode<T> parent, char key) {
        children = new HashMap<Character, TrieNode<T>>();
        setEndState(false);
        setParent(parent);
        setKey(key);
        setValue(null);
    }

    //	============================== Getters ==============================
    public TrieNode<T> getParent() {
        return parent;
    }

    public char getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }

    /**
     * @return the map whose keys and values are children's characters and nodes.
     */
    public Map<Character, TrieNode<T>> getChildrenMap() {
        return children;
    }

    public TrieNode<T> getChild(char key) {
        return children.get(key);
    }

    //	============================== Setters ==============================
    public void setParent(TrieNode<T> node) {
        parent = node;
    }

    public void setKey(char key) {
        this.key = key;
    }

    public T setValue(T value) {
        T tmp = value;
        this.value = value;
        return tmp;
    }

    public void setEndState(boolean endState) {
        end_state = endState;
    }

    public TrieNode<T> addChild(char key) {
        TrieNode<T> child = getChild(key);

        if (child == null) {
            child = new TrieNode<T>(this, key);
            children.put(key, child);
        }

        return child;
    }

//	============================== Checks ==============================

    /**
     * @return {@code true}} if this node is an end state; otherwise, {@code false}.
     */
    public boolean isEndState() {
        return end_state;
    }

    public boolean hasValue() {
        return value != null;
    }

    public boolean hasChildren() {
        return !children.isEmpty();
    }

    //	=================================================================
    public TrieNode<T> removeChild(char key) {
        return children.remove(key);
    }
}
