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

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class MaxFlow {
    private Map<Edge, Double> flow_map;
    private double maxflow;

    public MaxFlow(Graph graph) {
        init(graph);
    }

    public void init(Graph graph) {
        flow_map = new HashMap<>();
        maxflow = 0;

        for (Edge edge : graph.getAllEdges())
            flow_map.put(edge, 0d);
    }

    //	============================== Getters ==============================

    public double getMaxFlow() {
        return maxflow;
    }

    public double getResidual(Edge edge) {
        return edge.getWeight() - flow_map.get(edge);
    }

    //	============================== Setters ==============================

    public void updateFlow(List<Edge> path, double flow) {
        path.forEach(e -> updateFlow(e, flow));
        maxflow += flow;
    }

    public void updateFlow(Edge edge, double flow) {
        Double prev = flow_map.getOrDefault(edge, 0d);
        flow_map.put(edge, prev + flow);
    }
}
