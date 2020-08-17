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

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public abstract class MSTWord {
    List<WVPair> vertices;
    Graph graph;

    public MSTWord(InputStream in) {
        try {
            vertices = readVertices(in);
            graph = createGraph();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract Graph createGraph();

    public abstract SpanningTree getMinimumSpanningTree();

    public abstract List<String> getShortestPath(int source, int target);

    public List<WVPair> readVertices(InputStream in) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        List<WVPair> vertices = new ArrayList<>();
        Pattern p = Pattern.compile("\t");
        String line, word;
        double[] vector;
        String[] t;


        while ((line = reader.readLine()) != null) {
            t = p.split(line);
            word = t[0];
            vector = new double[t.length - 1];

            for (int i = 1; i < t.length; i++)
                vector[i - 1] = Double.parseDouble(t[i]);

            vertices.add(new WVPair(word, vector));
        }

        reader.close();
        return vertices;
    }

    public void printSpanningTree(OutputStream out, SpanningTree tree) {
        PrintStream fout = new PrintStream(new BufferedOutputStream(out));
        fout.println("digraph G {");

        for (Edge edge : tree.getEdges()) {
            fout.printf("\"%s\" -> \"%s\"[label=\"%5.4f\"];\n", vertices.get(edge.getSource()).getWord(), vertices.get(edge.getTarget()).getWord(), edge.getWeight());
        }

        fout.println("}");
        fout.close();
    }

    protected class WVPair {
        private String word;
        private double[] vector;

        public WVPair(String word, double[] vector) {
            this.word = word;
            this.vector = vector;
        }

        public String getWord() {
            return word;
        }

        public double[] getVector() {
            return vector;
        }
    }
}
