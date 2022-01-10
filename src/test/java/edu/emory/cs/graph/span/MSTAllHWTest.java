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
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class MSTAllHWTest {
    @Test
    public void testCompleteGraphs() {
        MSTAll gold = new MSTAllHWSol();
        long st, et;

        for (int i = 1; i < 10; i++) {
            st = System.currentTimeMillis();
            List<SpanningTree> list = gold.getMinimumSpanningTrees(getCompleteGraph(i));
            et = System.currentTimeMillis();
            System.out.printf("%3d: %8d, %d\n", i, list.size(), et - st);
        }
    }

    //	@Test
    public void test() {
        List<Graph> graphs = new ArrayList<>();
        graphs.add(getGraph1a());
        graphs.add(getGraph2a());
        graphs.add(getGraph3a());
        graphs.add(getGraph3b());
        graphs.add(getGraph3c());
        graphs.add(getGraph4a());
        graphs.add(getGraph4b());
        graphs.add(getGraph4c());
        graphs.add(getGraph5a());

        int i, correct = 0, total = graphs.size();
        MSTAll gold = new MSTAllHWSol();
        MSTAll system = new MSTAllHWSol();
        Graph graph;
        boolean b;

        for (i = 0; i < total; i++) {
            graph = graphs.get(i);
            b = false;

            try {
                if (test(gold.getMinimumSpanningTrees(graph), system.getMinimumSpanningTrees(graph))) {
                    b = true;
                    correct++;
                }
            } catch (Exception ignored) {}

            System.out.printf("%2d: %b\n", (i + 1), b);
        }

        System.out.printf("Score: %d/%d\n", correct, total);
    }

    Graph getGraph1a() {
        return new Graph(1);
    }

    Graph getGraph2a() {
        return new Graph(2);
    }

    Graph getGraph3a() {
        Graph graph = new Graph(3);

        graph.setUndirectedEdge(0, 1, 1);
        graph.setUndirectedEdge(0, 2, 1);
        graph.setUndirectedEdge(1, 2, 2);

        return graph;
    }

    Graph getGraph3b() {
        Graph graph = new Graph(3);

        graph.setUndirectedEdge(0, 1, 2);
        graph.setUndirectedEdge(0, 2, 2);
        graph.setUndirectedEdge(1, 2, 1);

        return graph;
    }

    Graph getGraph3c() {
        Graph graph = new Graph(3);

        graph.setUndirectedEdge(0, 1, 1);
        graph.setUndirectedEdge(0, 2, 2);
        graph.setUndirectedEdge(1, 2, 3);

        return graph;
    }

    Graph getGraph4a() {
        Graph graph = new Graph(4);

        graph.setUndirectedEdge(0, 1, 2);
        graph.setUndirectedEdge(0, 3, 1);
        graph.setUndirectedEdge(1, 2, 1);
        graph.setUndirectedEdge(2, 3, 2);

        return graph;
    }

    Graph getGraph4b() {
        Graph graph = new Graph(4);

        graph.setUndirectedEdge(0, 1, 3);
        graph.setUndirectedEdge(0, 3, 3);
        graph.setUndirectedEdge(1, 2, 1);
        graph.setUndirectedEdge(1, 3, 2);
        graph.setUndirectedEdge(2, 3, 2);

        return graph;
    }

    Graph getGraph4c() {
        Graph graph = new Graph(4);

        graph.setUndirectedEdge(0, 1, 1);
        graph.setUndirectedEdge(0, 2, 2);
        graph.setUndirectedEdge(0, 3, 3);
        graph.setUndirectedEdge(1, 2, 3);
        graph.setUndirectedEdge(1, 3, 2);
        graph.setUndirectedEdge(2, 3, 1);

        return graph;
    }

    Graph getGraph5a() {
        Graph graph = new Graph(5);

        graph.setUndirectedEdge(0, 1, 3);
        graph.setUndirectedEdge(0, 2, 4);
        graph.setUndirectedEdge(0, 3, 1);
        graph.setUndirectedEdge(0, 4, 2);
        graph.setUndirectedEdge(1, 2, 2);
        graph.setUndirectedEdge(2, 3, 4);
        graph.setUndirectedEdge(3, 4, 3);

        return graph;
    }

    Graph getGraph5b() {
        Graph graph = new Graph(5);

        graph.setUndirectedEdge(0, 1, 3);
        graph.setUndirectedEdge(0, 2, 4);
        graph.setUndirectedEdge(0, 3, 1);
        graph.setUndirectedEdge(0, 4, 1);
        graph.setUndirectedEdge(1, 2, 3);
        graph.setUndirectedEdge(1, 3, 5);
        graph.setUndirectedEdge(1, 4, 4);
        graph.setUndirectedEdge(2, 3, 1);
        graph.setUndirectedEdge(2, 4, 1);
        graph.setUndirectedEdge(3, 4, 3);

        return graph;
    }


    Graph getCompleteGraph(int V, Random rand) {
        Graph graph = new Graph(V);

        for (int i = 0; i < V - 1; i++)
            for (int j = i + 1; j < V; j++)
                graph.setUndirectedEdge(i, j, rand.nextInt(V) + 1);

        return graph;
    }

    Graph getCompleteGraph(int V) {
        Graph graph = new Graph(V);

        for (int i = 0; i < V - 1; i++)
            for (int j = i + 1; j < V; j++)
                graph.setUndirectedEdge(i, j, 1);

        return graph;
    }


    Graph getGraph0() {
        Graph graph = new Graph(5);

        graph.setUndirectedEdge(0, 1, 3);
        graph.setUndirectedEdge(0, 2, 4);
        graph.setUndirectedEdge(0, 3, 1);
        graph.setUndirectedEdge(0, 4, 2);
        graph.setUndirectedEdge(1, 2, 2);
        graph.setUndirectedEdge(2, 3, 4);
        graph.setUndirectedEdge(3, 4, 3);

        return graph;
    }

    Graph getHouse() {
        Graph quizgraph = new Graph(8);

        quizgraph.setUndirectedEdge(0, 1, 1.0);
        quizgraph.setUndirectedEdge(0, 2, 1.0);
        quizgraph.setUndirectedEdge(0, 3, 1.0);
        quizgraph.setUndirectedEdge(1, 2, 1.0);
        quizgraph.setUndirectedEdge(1, 3, 1.0);
        quizgraph.setUndirectedEdge(2, 3, 1.0);
        quizgraph.setUndirectedEdge(1, 7, 1.0);
        quizgraph.setUndirectedEdge(0, 7, 1.0);
        quizgraph.setUndirectedEdge(0, 4, 1.0);
        quizgraph.setUndirectedEdge(3, 4, 1.0);
        quizgraph.setUndirectedEdge(1, 6, 1.0);
        quizgraph.setUndirectedEdge(6, 2, 1.0);
        quizgraph.setUndirectedEdge(5, 3, 1.0);
        quizgraph.setUndirectedEdge(5, 2, 1.0);

        return quizgraph;
    }

    Graph getGraph1() {
        Graph graph = new Graph(4);

        graph.setUndirectedEdge(0, 1, 1);
        graph.setUndirectedEdge(0, 2, 1);
        graph.setUndirectedEdge(0, 3, 1);
        graph.setUndirectedEdge(1, 2, 1);
        graph.setUndirectedEdge(1, 3, 1);
        graph.setUndirectedEdge(2, 3, 1);

        return graph;
    }

    Graph getGraph(int n) {
        Graph graph = new Graph(n);
        int i, j;

        for (i = 0; i < n - 1; i++)
            for (j = i + 1; j < n; j++)
                graph.setUndirectedEdge(i, j, 1);

        return graph;
    }

    boolean test(List<SpanningTree> gTrees, List<SpanningTree> sTrees) {
        if (sTrees == null) return false;
        if (gTrees.size() != sTrees.size()) return false;

        Set<String> g = getSequenceSet(gTrees);
        Set<String> s = getSequenceSet(sTrees);

        if (g.size() != s.size()) return false;
        g.removeAll(s);
        return g.isEmpty();
    }

    public Set<String> getSequenceSet(List<SpanningTree> trees) {
        Set<String> set = new HashSet<>();

        for (SpanningTree tree : trees)
            set.add(getSequence(tree));

        return set;
    }

    public String getSequence(SpanningTree tree) {
        List<String> sequence = new ArrayList<>();
        String s;

        for (Edge edge : tree.getEdges()) {
            if (edge.getSource() < edge.getTarget())
                s = edge.getSource() + "-" + edge.getTarget();
            else
                s = edge.getTarget() + "-" + edge.getSource();

            sequence.add(s);
        }

        Collections.sort(sequence);
        return String.join(" ", sequence);
    }
}
