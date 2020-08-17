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
package edu.emory.cs.tree;

import edu.emory.cs.tree.balanced.AVLNode;
import edu.emory.cs.tree.balanced.RedBlackNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class NodeTest {
    @Test
    public void testBinaryNode() {
        BinaryNode<Integer> one = new BinaryNode<>(1);
        BinaryNode<Integer> two = new BinaryNode<>(2);
        BinaryNode<Integer> three = new BinaryNode<>(3);
        BinaryNode<Integer> four = new BinaryNode<>(4);
        BinaryNode<Integer> five = new BinaryNode<>(5);
        BinaryNode<Integer> six = new BinaryNode<>(6);

        four.setLeftChild(two);
        four.setRightChild(five);
        two.setLeftChild(one);
        two.setRightChild(three);

        assertFalse(four.hasParent());
        assertEquals(four, two.getParent());
        assertEquals(two, four.getLeftChild());
        assertEquals(five, four.getRightChild());
        assertEquals(four, one.getGrandParent());
        assertEquals(three, one.getSibling());
        assertEquals(five, one.getUncle());

        four.replaceChild(five, six);
        assertEquals(four, six.getParent());
        assertEquals(six, four.getRightChild());
    }

    @Test
    public void testAVLNode() {
        AVLNode<Integer> one = new AVLNode<>(1);
        AVLNode<Integer> two = new AVLNode<>(2);
        AVLNode<Integer> three = new AVLNode<>(3);
        AVLNode<Integer> four = new AVLNode<>(4);
        AVLNode<Integer> five = new AVLNode<>(5);

        assertEquals(1, four.getHeight());
        assertEquals(0, four.getBalanceFactor());

        four.setLeftChild(two);
        assertEquals(2, four.getHeight());
        assertEquals(1, two.getHeight());
        assertEquals(1, four.getBalanceFactor());

        two.setRightChild(three);
        assertEquals(3, four.getHeight());
        assertEquals(2, two.getHeight());
        assertEquals(2, four.getBalanceFactor());
        assertEquals(-1, two.getBalanceFactor());

        two.setLeftChild(one);
        assertEquals(3, four.getHeight());
        assertEquals(2, two.getHeight());
        assertEquals(2, four.getBalanceFactor());
        assertEquals(0, two.getBalanceFactor());

        four.setRightChild(five);
        assertEquals(3, four.getHeight());
        assertEquals(1, four.getBalanceFactor());
    }

    @Test
    public void testRedBlackNode() {
        RedBlackNode<Integer> node = new RedBlackNode<>(1);
        assertTrue(node.isRed());

        node.setToBlack();
        assertTrue(node.isBlack());

        node.setToRed();
        assertTrue(node.isRed());
    }
}
