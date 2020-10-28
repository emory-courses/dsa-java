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
package edu.emory.cs.graph.span;

import edu.emory.cs.graph.Edge;
import edu.emory.cs.graph.Graph;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class MSTPrim implements MST {
    @Override
    public SpanningTree getMinimumSpanningTree(Graph graph) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        SpanningTree tree = new SpanningTree();
        Set<Integer> visited = new HashSet<>();
        Edge edge;

        // add all connecting vertices from start vertex to the queue
        add(queue, visited, graph, 0);

        while (!queue.isEmpty()) {
            edge = queue.poll();

            if (!visited.contains(edge.getSource())) {
                tree.addEdge(edge);
                // if a spanning tree is found, break.
                if (tree.size() + 1 == graph.size()) break;
                // add all connecting vertices from current vertex to the queue
                add(queue, visited, graph, edge.getSource());
            }
        }

        return tree;
    }

    /**
     * Adds the target to the visited set, and adds the incoming edges of the target vertex that have not been visited to the queue.
     * @param queue   queue of incoming edges to explore.
     * @param visited set of visited vertices.
     * @param graph   the graph to find the minimum spanning tree from.
     * @param target  the target vertex to be added.
     */
    private void add(PriorityQueue<Edge> queue, Set<Integer> visited, Graph graph, int target) {
        visited.add(target);
        for (Edge edge : graph.getIncomingEdges(target)) {
            if (!visited.contains(edge.getSource()))
                queue.add(edge);
        }

//        graph.getIncomingEdges(target).stream().
//                filter(edge -> !visited.contains(edge.getSource())).
//                collect(Collectors.toCollection(() -> queue));
    }
}
