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
package edu.emory.cs.graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** @author Jinho D. Choi */
public class GraphQuizTest {
    @Test
    public void testQuiz0() {
        GraphQuizSol g = new GraphQuizSol(5);
        g.setDirectedEdge(0, 1, 0);
        g.setDirectedEdge(0, 2, 0);
        g.setDirectedEdge(2, 1, 0);
        g.setDirectedEdge(2, 3, 0);
        g.setDirectedEdge(3, 4, 0);
        g.setDirectedEdge(4, 2, 0);

        assertEquals(1, g.numberOfCycles());
    }

    @Test
    public void testQuiz1() {
        GraphQuizSol g = new GraphQuizSol(5);
        g.setDirectedEdge(0, 2, 0);
        g.setDirectedEdge(1, 0, 0);
        g.setDirectedEdge(2, 1, 0);
        g.setDirectedEdge(2, 3, 0);
        g.setDirectedEdge(3, 4, 0);
        g.setDirectedEdge(4, 2, 0);

        assertEquals(2, g.numberOfCycles());
    }

    @Test
    public void testQuiz2() {
        GraphQuizSol g = new GraphQuizSol(6);
        g.setDirectedEdge(0, 2, 0);
        g.setDirectedEdge(1, 0, 0);
        g.setDirectedEdge(2, 1, 0);
        g.setDirectedEdge(3, 4, 0);
        g.setDirectedEdge(4, 5, 0);
        g.setDirectedEdge(5, 3, 0);

        assertEquals(2, g.numberOfCycles());
    }

    @Test
    public void testQuiz3() {
        GraphQuizSol g = new GraphQuizSol(5);
        g.setDirectedEdge(0, 1, 0);
        g.setDirectedEdge(1, 2, 0);
        g.setDirectedEdge(1, 3, 0);
        g.setDirectedEdge(2, 0, 0);
        g.setDirectedEdge(3, 4, 0);
        g.setDirectedEdge(4, 2, 0);

        assertEquals(2, g.numberOfCycles());
    }

    @Test
    public void testQuiz4() {
        GraphQuizSol g = new GraphQuizSol(6);
        g.setDirectedEdge(0, 1, 0);
        g.setDirectedEdge(1, 2, 0);
        g.setDirectedEdge(1, 3, 0);
        g.setDirectedEdge(2, 0, 0);
        g.setDirectedEdge(2, 4, 0);
        g.setDirectedEdge(3, 4, 0);
        g.setDirectedEdge(4, 1, 0);
        g.setDirectedEdge(4, 5, 0);
        g.setDirectedEdge(5, 2, 0);

        assertEquals(5, g.numberOfCycles());
    }

    @Test
    public void testQuiz5() {
        GraphQuizSol g = new GraphQuizSol(4);
        g.setUndirectedEdge(0, 1, 0);
        g.setUndirectedEdge(1, 2, 0);
        g.setUndirectedEdge(2, 3, 0);
        g.setUndirectedEdge(3, 0, 0);

        assertEquals(6, g.numberOfCycles());
    }

    @Test
    public void testQuiz6() {
        GraphQuizSol g = new GraphQuizSol(6);
        g.setDirectedEdge(0, 1, 0);
        g.setDirectedEdge(0, 4, 0);
        g.setDirectedEdge(1, 2, 0);
        g.setDirectedEdge(1, 4, 0);
        g.setDirectedEdge(2, 0, 0);
        g.setDirectedEdge(2, 5, 0);
        g.setDirectedEdge(3, 0, 0);
        g.setDirectedEdge(4, 2, 0);
        g.setDirectedEdge(4, 3, 0);
        g.setDirectedEdge(5, 4, 0);

        assertEquals(7, g.numberOfCycles());
    }
}
