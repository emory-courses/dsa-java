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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class GraphTest {
    @Test
    public void testContainsCycle() {
        Graph graph = new Graph(5);

        graph.setDirectedEdge(0, 1, 1);
        graph.setDirectedEdge(0, 2, 1);
        graph.setDirectedEdge(2, 1, 1);
        graph.setDirectedEdge(2, 3, 1);
        graph.setDirectedEdge(3, 4, 1);
        graph.setDirectedEdge(4, 2, 1);

        System.out.println(graph.toString());
        assertTrue(graph.containsCycle());
    }

    @Test
    public void testTopologicalSort() {
		Graph graph = new Graph(8);

		graph.setDirectedEdge(0, 3, 1);
		graph.setDirectedEdge(0, 4, 1);
		graph.setDirectedEdge(1, 3, 1);
		graph.setDirectedEdge(2, 4, 1);
		graph.setDirectedEdge(3, 5, 1);
		graph.setDirectedEdge(3, 6, 1);
		graph.setDirectedEdge(3, 7, 1);
		graph.setDirectedEdge(4, 6, 1);
		graph.setDirectedEdge(2, 7, 1);

		assertEquals("[0, 1, 2, 3, 4, 5, 7, 6]", new Graph(graph).topological_sort(false).toString());
        assertEquals("[0, 1, 3, 5, 2, 4, 6, 7]", new Graph(graph).topological_sort(true).toString());
    }
}
