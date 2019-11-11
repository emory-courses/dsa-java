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

import edu.emory.cs.graph.Edge;
import edu.emory.cs.graph.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class TopologicalSort {
    public List<Integer> sort(Graph graph) {
        Deque<Integer> global = graph.getVerticesWithNoIncomingEdges();
        Deque<Edge>[] outgoingEdgesAll = graph.getOutgoingEdges();
        List<Integer> order = new ArrayList<>();

        while (!global.isEmpty()) {
            Deque<Integer> local = new ArrayDeque<>();
            int vertex = global.poll();

            //Add vertex to the sequence
            order.add(vertex);
            Deque<Edge> outgoingEdges = outgoingEdgesAll[vertex];

            while (!outgoingEdges.isEmpty()) {
                Edge edge = outgoingEdges.poll();
                List<Edge> incomingEdges = graph.getIncomingEdges(edge.getTarget());

                //Remove edge in all incomingEdges of the target vertex
                incomingEdges.remove(edge);

                //If the vertex has no incoming edges, add it to the local queue awaited to be added to the global deque
                if (incomingEdges.isEmpty())
                    local.add(edge.getTarget());
            }

            //Transfer all vertices in local to global
            while (!local.isEmpty())
                // breath-first search
                global.addLast(local.removeFirst());
               // depth-first search
               // global.addFirst(local.removeLast());
        }

        if (!graph.isEmpty()) throw new IllegalArgumentException("Cyclic graph.");
        return order;
    }
}
