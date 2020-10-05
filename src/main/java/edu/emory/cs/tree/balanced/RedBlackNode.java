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
package edu.emory.cs.tree.balanced;

import edu.emory.cs.tree.AbstractBinaryNode;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class RedBlackNode<T extends Comparable<T>> extends AbstractBinaryNode<T, RedBlackNode<T>> {
    /** If true, this node is red; otherwise, black. */
    private boolean is_red;

    public RedBlackNode(T key) {
        super(key);
        setToRed();
    }

    public void setToRed() {
        is_red = true;
    }

    public void setToBlack() {
        is_red = false;
    }

    public boolean isRed() {
        return is_red;
    }

    public boolean isBlack() {
        return !is_red;
    }

    @Override
    public String toString() {
        String color = isRed() ? "R" : "B";
        return key + ":" + color + " -> (" + left_child + ", " + right_child + ")";
    }
}
