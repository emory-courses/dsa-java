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
package edu.emory.cs.graph.span;

import edu.emory.cs.graph.Edge;
import edu.emory.cs.graph.Graph;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class MSTPrim implements MSTAlgorithm {
    @Override
    public SpanningTree getMinimumSpanningTree(Graph graph) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        SpanningTree tree = new SpanningTree();
        Set<Integer> visited = new HashSet<>();
        Edge edge;

        //Add all connecting vertices from start vertex to the queue
        add(queue, visited, graph, 0);

        while (!queue.isEmpty()) {
            edge = queue.poll();

            if (!visited.contains(edge.getSource())) {
                tree.addEdge(edge);

                //If a spanning tree is found, break.
                if (tree.size() + 1 == graph.size()) break;

                //Add all connecting vertices from current vertex to the queue
                add(queue, visited, graph, edge.getSource());
            }
        }

        return tree;
    }

    /**
     * @param queue   Queue of all vertices awaited to explore
     * @param visited Set of visited vertices
     * @param graph   Graph
     * @param target  Target vertex
     */
    private void add(PriorityQueue<Edge> queue, Set<Integer> visited, Graph graph, int target) {
        visited.add(target);

        for (Edge edge : graph.getIncomingEdges(target)) {
            if (!visited.contains(edge.getSource()))
                queue.add(edge);
        }
    }
}
