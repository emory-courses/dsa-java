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

import java.util.*;


/** @author Jinho D. Choi ({@code jinho.choi@emory.edu}) */
public class SpanningTree implements Comparable<SpanningTree> {
    private final List<Edge> edges;
    private double total_weight;

    public SpanningTree() {
        edges = new ArrayList<>();
    }

    public SpanningTree(SpanningTree tree) {
        edges = new ArrayList<>(tree.getEdges());
        total_weight = tree.getTotalWeight();
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public double getTotalWeight() {
        return total_weight;
    }

    public int size() {
        return edges.size();
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
        total_weight += edge.getWeight();
    }

    @Override
    public int compareTo(SpanningTree tree) {
        double diff = total_weight - tree.total_weight;
        if (diff > 0) return 1;
        else if (diff < 0) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();

        for (Edge edge : edges)
            build.append(String.format("\n%d <- %d : %f", edge.getTarget(), edge.getSource(), edge.getWeight()));

        return build.length() > 0 ? build.substring(1) : "";
    }

    public String getUndirectedSequence() {
        int i, size = size(), min, max;
        int[] array = new int[size];
        Edge edge;

        for (i = 0; i < size; i++) {
            edge = edges.get(i);

            if (edge.getSource() < edge.getTarget()) {
                min = edge.getSource();
                max = edge.getTarget();
            }
            else {
                min = edge.getTarget();
                max = edge.getSource();
            }

            array[i] = min * (size + 1) + max;
        }

        Arrays.sort(array);
        return Arrays.toString(array);
    }

    // ========================= For MSTEdmonds.java =========================

    public Set<Integer> getTargets() {
        Set<Integer> set = new HashSet<>();

        for (Edge edge : edges)
            set.add(edge.getTarget());

        return set;
    }

    public List<List<Edge>> getCycles() {
        Map<Integer, List<Edge>> edgeMap = getEdgeMap();
        List<List<Edge>> cycles = new ArrayList<>();
        getCyclesAux(cycles, edgeMap, new ArrayList<>(), new HashSet<>(), getAnyEdge(edgeMap));
        return cycles;
    }

    /** @return Map whose keys are source vertices and keys are the edges. */
    private Map<Integer, List<Edge>> getEdgeMap() {
        Map<Integer, List<Edge>> map = new HashMap<>();
        List<Edge> tmp;

        for (Edge edge : edges) {
            tmp = map.computeIfAbsent(edge.getSource(), k -> new ArrayList<>());
            tmp.add(edge);
        }

        return map;
    }

    private Edge getAnyEdge(Map<Integer, List<Edge>> map) {
        for (List<Edge> edge : map.values())
            return edge.get(0);
        return null;
    }

    private void getCyclesAux(List<List<Edge>> cycles, Map<Integer, List<Edge>> edgeMap, List<Edge> cycle, Set<Integer> set, Edge curr) {
        if (edgeMap.isEmpty()) return;
        set.add(curr.getSource());
        cycle.add(curr);

        if (set.contains(curr.getTarget()))        // cycle
        {
            removeAll(edgeMap, set, cycle);
            cycles.add(cycle);
            getCyclesAux(cycles, edgeMap, new ArrayList<>(), new HashSet<>(), getAnyEdge(edgeMap));
        }
        else {
            List<Edge> tmp = edgeMap.get(curr.getTarget());

            if (tmp == null) {
                removeAll(edgeMap, set, cycle);
                getCyclesAux(cycles, edgeMap, new ArrayList<>(), new HashSet<>(), getAnyEdge(edgeMap));
            }
            else {
                for (Edge edge : new ArrayList<>(tmp))
                    getCyclesAux(cycles, edgeMap, new ArrayList<>(cycle), new HashSet<>(set), edge);
            }
        }
    }

    private void removeAll(Map<Integer, List<Edge>> map, Set<Integer> set, List<Edge> cycle) {
        List<Edge> tmp;

        for (int source : set) {
            tmp = map.get(source);

            if (tmp != null) {
                tmp.removeAll(cycle);
                if (tmp.isEmpty()) map.remove(source);
            }
        }
    }
}
