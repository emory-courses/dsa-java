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
package edu.emory.cs.tree;

import edu.emory.cs.tree.balanced.AVLTree;
import edu.emory.cs.tree.balanced.RedBlackTree;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class TreeTest {
    @Test
    public void testRedBlackTree() {
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(1);
        System.out.println(tree.toString());

        tree = new RedBlackTree<>();
        tree.add(1);
        tree.add(3);
        tree.add(5);
        System.out.println(tree.toString());

        tree = new RedBlackTree<>();
        tree.add(3);
        tree.add(1);
        tree.add(2);
        System.out.println(tree.toString());

        tree = new RedBlackTree<>();
        tree.add(3);
        tree.add(5);
        tree.add(4);
        System.out.println(tree.toString());


        tree = new RedBlackTree<>();
        tree.add(3);
        tree.add(5);
        tree.add(4);
        System.out.println(tree.toString());
    }

    @Test
    @Ignore
    public void testAVLTree() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(1);
        System.out.println(tree.toString());

        tree = new AVLTree<>();
        tree.add(1);
        tree.add(3);
        tree.add(5);
        System.out.println(tree.toString());

        tree = new AVLTree<>();
        tree.add(3);
        tree.add(1);
        tree.add(2);
        System.out.println(tree.toString());

        tree = new AVLTree<>();
        tree.add(3);
        tree.add(5);
        tree.add(4);
        System.out.println(tree.toString());


        tree = new AVLTree<>();
        tree.add(3);
        tree.add(5);
        tree.add(4);
        System.out.println(tree.toString());
    }

    @Test
    public void testBinarySearchTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.add(5);
        tree.add(3);
        tree.add(1);
        tree.add(4);
        tree.add(2);
        tree.add(7);
        tree.add(6);
        tree.add(8);

        assertEquals(1, tree.min().intValue());
        assertEquals(8, tree.max().intValue());
        assertTrue(tree.contains(7));
        assertFalse(tree.contains(0));

        assertEquals(2, tree.remove(2).getKey().intValue());    // no child
        assertEquals(3, tree.remove(3).getKey().intValue());    // two children
        assertNull(tree.remove(2));
        tree.add(2);
        assertEquals(1, tree.remove(1).getKey().intValue());    // only right child
        assertEquals(4, tree.remove(4).getKey().intValue());    // only left child
        assertEquals(5, tree.remove(5).getKey().intValue());    // root
    }

    @Test
    @Ignore
    public void testAccuracy() {
        testAccuracy(1000, 1000, new BinarySearchTree<>());
        testAccuracy(1000, 1000, new AVLTree<>());
        testAccuracy(1000, 1000, new RedBlackTree<>());
    }

    private void testAccuracy(final int ITERATIONS, final int SIZE, AbstractBinarySearchTree<Integer, ?> tree) {
        Random rand = new Random(0);
        List<Integer> list;

        for (int i = 0; i < ITERATIONS; i++) {
            list = Stream.generate(rand::nextInt).limit(SIZE).collect(Collectors.toList());
            for (int key : list) tree.add(key);
            for (int key : list) assertTrue(tree.contains(key));

            assertEquals(tree.max(), Collections.max(list));
            assertEquals(tree.min(), Collections.min(list));

            Collections.shuffle(list);

            for (int key : list)
                assertEquals(key, tree.remove(key).getKey().intValue());
        }
    }
}
