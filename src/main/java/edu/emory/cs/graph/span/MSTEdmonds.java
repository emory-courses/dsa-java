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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class MSTEdmonds implements MST {
    @Override
    public SpanningTree getMinimumSpanningTree(Graph graph) {
        List<Set<Integer>> forest = initForest(graph.size());
        List<Edge> cyclicEdges = new ArrayList<>();
        SpanningTree tree = null;
        List<List<Edge>> cycles;

        while (true) {
            tree = getMinimumIncomingEdges(graph, forest);
            cycles = tree.getCycles();
            if (cycles.isEmpty()) {
                //Add all corresponding found cyclic edges to spanning tree
                addEdgesFromCycles(tree, cyclicEdges);
                break;
            }

            //Update and merge forest
            forest = updateEdgeWeights(graph, cycles);

            //Update all cyclic edges
            addAll(cyclicEdges, cycles);
        }

        return tree;
    }

    private List<Set<Integer>> initForest(int size) {
        List<Set<Integer>> forest = new ArrayList<>();
        Set<Integer> set;

        for (int i = 0; i < size; i++) {
            set = new HashSet<>();
            set.add(i);
            forest.add(set);
        }

        return forest;
    }

    private SpanningTree getMinimumIncomingEdges(Graph graph, List<Set<Integer>> forest) {
        SpanningTree tree = new SpanningTree();
        Edge min;

        for (Set<Integer> subTree : forest) {
            min = null;

            for (int vertex : subTree) {
                for (Edge edge : graph.getIncomingEdges(vertex)) {
                    if (!subTree.contains(edge.getSource()) && (min == null || min.getWeight() > edge.getWeight()))
                        min = edge;
                }
            }

            if (min != null) tree.addEdge(min);
        }

        return tree;
    }

    private double getChainedWeight(List<Edge> cycle, int source) {
        double sum = 0;

        for (Edge edge : cycle) {
            if (edge.getTarget() != source)
                sum += edge.getWeight();
        }

        return sum;
    }

    private Set<Integer> getVertices(List<Edge> edges) {
        Set<Integer> set = new HashSet<>();

        for (Edge edge : edges) {
            set.add(edge.getSource());
            set.add(edge.getTarget());
        }

        return set;
    }

    private List<Set<Integer>> updateEdgeWeights(Graph graph, List<List<Edge>> cycles) {
        List<Set<Integer>> forest = new ArrayList<>();
        Set<Integer> set, all = new HashSet<>();
        Edge edge;

        for (List<Edge> cycle : cycles) {
            set = getVertices(cycle);
            all.addAll(set);
            forest.add(set);

            for (int i = 0; i < cycle.size(); i++) {
                edge = cycle.get(i);

                for (Edge iEdge : graph.getIncomingEdges(edge.getSource())) {
                    if (!set.contains(iEdge.getSource()))
                        iEdge.addWeight(getChainedWeight(cycle, edge.getSource()));
                }
            }
        }

        for (int i = 0; i < graph.size(); i++) {
            if (!all.contains(i)) {
                set = new HashSet<>();
                set.add(i);
                forest.add(set);
            }
        }

        return forest;
    }

    private void addEdgesFromCycles(SpanningTree tree, List<Edge> cyclicEdges) {
        Set<Integer> targets = tree.getTargets();

        for (Edge edge : cyclicEdges) {
            if (!targets.contains(edge.getTarget()))
                tree.addEdge(edge);
        }
    }

    private void addAll(List<Edge> toList, List<List<Edge>> from) {
        for (List<Edge> list : from)
            toList.addAll(list);
    }
}
