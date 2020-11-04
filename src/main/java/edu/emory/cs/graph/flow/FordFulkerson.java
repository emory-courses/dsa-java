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
package edu.emory.cs.graph.flow;

import edu.emory.cs.graph.Edge;
import edu.emory.cs.graph.Graph;
import edu.emory.cs.graph.Subgraph;

import java.util.List;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class FordFulkerson implements NetworkFlow {
    /**
     * @param graph  a graph.
     * @param source the source vertex.
     * @param target the target vertex.
     * @return the maximum flow from the source to the target vertices.
     */
    public MaxFlow getMaximumFlow(Graph graph, int source, int target) {
        MaxFlow mf = new MaxFlow(graph);
        Subgraph sub;

        //Continuously find a new path to push flow from source to target
        while ((sub = getAugmentingPath(graph, mf, new Subgraph(), source, target)) != null) {
            //Get the edge with the minimum edge
            double min = getMin(mf, sub.getEdges());

            //Update all forward path edges with -min.getWeight()
            mf.updateFlow(sub.getEdges(), min);
            //Update all backward path edges with +min.getWeight()
            updateBackward(graph, sub, mf, min);
        }

        return mf;
    }

    /**
     * @param graph Graph
     * @param sub   that contains both forward (and backward) edges
     * @param mf    Found MaxFlow
     * @param min   Found weight of edge with minimum weight within the path list
     */
    protected void updateBackward(Graph graph, Subgraph sub, MaxFlow mf, double min) {
        boolean found;

        for (Edge edge : sub.getEdges()) {
            found = false;

            for (Edge rEdge : graph.getIncomingEdges(edge.getSource())) {
                if (rEdge.getSource() == edge.getTarget()) {
                    mf.updateFlow(rEdge, -min);
                    found = true;
                    break;
                }
            }

            if (!found) {
                Edge rEdge = graph.setDirectedEdge(edge.getTarget(), edge.getSource(), 0);
                mf.updateFlow(rEdge, -min);
            }
        }
    }

    /**
     * @param mf   Found MaxFlow
     * @param path Found path from source to target
     * @return weight of edge with minimum weight within the path list
     */
    private double getMin(MaxFlow mf, List<Edge> path) {
        double min = mf.getResidual(path.get(0));

        for (int i = 1; i < path.size(); i++)
            min = Math.min(min, mf.getResidual(path.get(i)));

        return min;
    }

    /**
     * @param graph  Graph
     * @param mf     MaxFlow currently found
     * @param sub    Subgraph that contains both forward (and backward) edges
     * @param source Source vertex
     * @param target Target vertex
     * @return Augmented subgraph
     */
    private Subgraph getAugmentingPath(Graph graph, MaxFlow mf, Subgraph sub, int source, int target) {
        if (source == target) return sub;
        Subgraph tmp;

        for (Edge edge : graph.getIncomingEdges(target)) {
            if (sub.contains(edge.getSource())) continue;    // cycle
            if (mf.getResidual(edge) <= 0) continue;    // no residual
            tmp = new Subgraph(sub);
            tmp.addEdge(edge);
            tmp = getAugmentingPath(graph, mf, tmp, source, edge.getSource());
            if (tmp != null) return tmp;
        }

        return null;
    }
}
