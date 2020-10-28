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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class Subgraph {
    private final List<Edge> edges;
    private final Set<Integer> vertices;

    public Subgraph() {
        edges = new ArrayList<>();
        vertices = new HashSet<>();
    }

    public Subgraph(Subgraph graph) {
        edges = new ArrayList<>(graph.getEdges());
        vertices = new HashSet<>(graph.getVertices());
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public Set<Integer> getVertices() {
        return vertices;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
        vertices.add(edge.getSource());
        vertices.add(edge.getTarget());
    }

    public boolean contains(int vertex) {
        return vertices.contains(vertex);
    }
}
