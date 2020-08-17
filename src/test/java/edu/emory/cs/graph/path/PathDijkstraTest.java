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
package edu.emory.cs.graph.path;

import edu.emory.cs.graph.Graph;
import org.junit.Test;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class PathDijkstraTest {
    @Test
    public void test() {
        Dijkstra d = new Dijkstra();
        Graph g = new Graph(6);

        g.setDirectedEdge(0, 1, 4);
        g.setDirectedEdge(0, 2, 2);
        g.setDirectedEdge(1, 2, 5);
        g.setDirectedEdge(1, 3, 10);
        g.setDirectedEdge(2, 4, 3);
        g.setDirectedEdge(3, 5, 3);
        g.setDirectedEdge(4, 3, 4);
        g.setDirectedEdge(4, 5, 9);

        System.out.println(d.getShortestPath(g, 0, 5));
    }
}
