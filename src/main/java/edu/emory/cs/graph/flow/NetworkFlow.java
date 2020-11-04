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


import edu.emory.cs.graph.Graph;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public interface NetworkFlow {
    /**
     * @param graph  a graph.
     * @param source the source vertex.
     * @param target the target vertex.
     * @return the maximum flow from the source to the target vertices.
     */
    MaxFlow getMaximumFlow(Graph graph, int source, int target);
}
