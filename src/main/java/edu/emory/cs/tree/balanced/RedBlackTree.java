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

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class RedBlackTree<T extends Comparable<T>> extends AbstractBalancedBinarySearchTree<T, RedBlackNode<T>> {
    @Override
    public RedBlackNode<T> createNode(T key) {
        return new RedBlackNode<T>(key);
    }

    @Override
    protected void balance(RedBlackNode<T> node) {
        if (isRoot(node))
            node.setToBlack();
        else if (node.getParent().isRed()) {
            RedBlackNode<T> uncle = node.getUncle();

            if (uncle != null && uncle.isRed())
                balanceWithRedUncle(node, uncle);
            else
                balanceWithBlackUncle(node);
        }
    }

    /**
     * color(node) = red & color(parent) = red.
     */
    private void balanceWithRedUncle(RedBlackNode<T> node, RedBlackNode<T> uncle) {
        node.getParent().setToBlack();
        uncle.setToBlack();
        RedBlackNode<T> grandParent = node.getGrandParent();
        grandParent.setToRed();
        balance(grandParent);
    }

    /**
     * color(node) = red & color(parent) = red.
     */
    private void balanceWithBlackUncle(RedBlackNode<T> node) {
        /* Rotation cases (G = grandparent, P = parent, C = child)
         * Case 1:
         *     G
         *    /
         *   P
         *  /
         * C
         *
         * Case 2:
         *   G
         *  /
         * P
         *  \
         *   C
         *
         * Case 3:
         * G
         *  \
         *   P
         *    \
         *     C
         * Case 4:
         * G
         *  \
         *   P
         *  /
         * C
         */

        RedBlackNode<T> grandParent = node.getGrandParent();

        if (grandParent != null) {
            RedBlackNode<T> parent = node.getParent();

            if (grandParent.isLeftChild(parent) && parent.isRightChild(node)) {       // Case 2
                rotateLeft(parent);
                node = parent;
            }
            else if (grandParent.isRightChild(parent) && parent.isLeftChild(node)) {       // Case 4
                rotateRight(parent);
                node = parent;
            }

            node.getParent().setToBlack();
            grandParent.setToRed();

            if (node.getParent().isLeftChild(node))        // Case 1
                rotateRight(grandParent);
            else
                rotateLeft(grandParent);            // Case 3
        }
    }
}
