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
package edu.emory.cs.graph.sort;

import edu.emory.cs.graph.Graph;
import org.junit.Test;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class TopologicalSortTest {
    @Test
    public void test() {
//		Graph graph = new Graph(8);
//		
//		graph.setDirectedEdge(0, 3, 1);
//		graph.setDirectedEdge(0, 4, 1);
//		graph.setDirectedEdge(1, 3, 1);
//		graph.setDirectedEdge(2, 4, 1);
//		graph.setDirectedEdge(3, 5, 1);
//		graph.setDirectedEdge(3, 6, 1);
//		graph.setDirectedEdge(3, 7, 1);
//		graph.setDirectedEdge(4, 6, 1);
//		graph.setDirectedEdge(2, 7, 1);
//		
//		TopologicalSort s = new TopologicalSort();
//		System.out.println(s.sort(graph).toString());

        Graph graph = new Graph(5);

        graph.setDirectedEdge(0, 1, 1);
        graph.setDirectedEdge(0, 2, 1);
        graph.setDirectedEdge(2, 1, 1);
        graph.setDirectedEdge(2, 3, 1);
        graph.setDirectedEdge(3, 4, 1);
        graph.setDirectedEdge(4, 2, 1);

        System.out.println(graph.toString());
        System.out.println(graph.containsCycle());
    }
}
