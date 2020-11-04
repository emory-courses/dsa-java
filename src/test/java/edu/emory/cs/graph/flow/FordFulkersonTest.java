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
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class FordFulkersonTest {
    @Test
    public void test() {
        NetworkFlow mfa = new FordFulkerson();
        Graph graph;
        double mf;

        graph = getGraph0();
        mf = test(mfa, graph, 0, graph.size() - 1);
        assertEquals(5, (int) mf);

        graph = getGraph1();
        mf = test(mfa, graph, 0, graph.size() - 1);
        assertEquals(2, (int) mf);
    }

    @Test
    public void testUnDirected() {
        NetworkFlow mfa = new FordFulkerson();
        Graph graph;
        double mf;

        graph = getGraph0();
        mf = test(mfa, graph, 0, graph.size() - 1);
        assertEquals(5, (int) mf);

        graph = getGraph1();
        mf = test(mfa, graph, 0, graph.size() - 1);
        assertEquals(2, (int) mf);
    }

    double test(NetworkFlow mfa, Graph graph, int source, int target) {
        MaxFlow m = mfa.getMaximumFlow(graph, source, target);
        return m.getMaxFlow();
    }

    Graph getGraph0() {
        Graph graph = new Graph(6);
        int s = 0, t = 5;

        graph.setDirectedEdge(s, 1, 4);
        graph.setDirectedEdge(s, 2, 2);
        graph.setDirectedEdge(1, 3, 3);
        graph.setDirectedEdge(2, 3, 2);
        graph.setDirectedEdge(2, 4, 3);
        graph.setDirectedEdge(3, 2, 1);
        graph.setDirectedEdge(3, t, 2);
        graph.setDirectedEdge(4, t, 4);

        return graph;
    }

    public Graph getGraph1() {
        Graph graph = new Graph(4);
        int s = 0, t = 3;

        graph.setDirectedEdge(2, t, 1);
        graph.setDirectedEdge(1, t, 1);
        graph.setDirectedEdge(1, 2, 1);
        graph.setDirectedEdge(s, 2, 1);
        graph.setDirectedEdge(s, 1, 1);

        return graph;
    }
}
