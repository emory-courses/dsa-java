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
public class AVLTree<T extends Comparable<T>> extends AbstractBalancedBinarySearchTree<T, AVLNode<T>> {
    @Override
    public AVLNode<T> createNode(T key) {
        return new AVLNode<>(key);
    }

    @Override
    protected void rotateLeft(AVLNode<T> node) {
        super.rotateLeft(node);
        node.resetHeights();
    }

    @Override
    protected void rotateRight(AVLNode<T> node) {
        super.rotateRight(node);
        node.resetHeights();
    }

    @Override
    protected void balance(AVLNode<T> node) {
        /* Rotation cases (N = node, C = child)
         * Case 1:
         *     N
         *    /
         *   C
         *  /
         * O
         *
         * Case 2:
         *   N
         *  /
         * C
         *  \
         *   O
         *
         * Case 3:
         * N
         *  \
         *   C
         *    \
         *     O
         * Case 4:
         * N
         *  \
         *   C
         *  /
         * O
         */

        if (node == null) return;
        int bf = node.getBalanceFactor();

        if (bf == 2) {
            AVLNode<T> child = node.getLeftChild();

            if (child.getBalanceFactor() == -1)    // Case 2
                rotateLeft(child);

            rotateRight(node);        // Case 1
        }
        else if (bf == -2) {
            AVLNode<T> child = node.getRightChild();

            if (child.getBalanceFactor() == 1)        // Case 4
                rotateRight(child);

            rotateLeft(node);        // Case 3
        }
        else
            balance(node.getParent());
    }
}
