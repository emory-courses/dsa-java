/*
 * Copyright 2015, Emory University
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

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class MSTWord {
    private List<String> words;
    private List<float[]> vectors;

    public void readVectors(InputStream in) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        Pattern p = Pattern.compile("\t");
        String line, word;
        float[] vector;
        String[] t;

        words = new ArrayList<>();
        vectors = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            t = p.split(line);
            word = t[0];
            vector = new float[t.length - 1];

            for (int i = 1; i < t.length; i++)
                vector[i - 1] = Float.parseFloat(t[i]);

            words.add(word);
            vectors.add(vector);
        }

        reader.close();
    }

    public SpanningTree findMinimumSpanningTree() {
        SpanningTree tree = new SpanningTree();

        // TODO: This code produces a dummy graph
        Random rand = new Random();
        int size = words.size();

        for (int source = 0; source < size; source++) {
            int target = 0;

            while (true) {
                target = rand.nextInt(size);
                if (target != source) break;
            }

            tree.addEdge(new Edge(source, target, rand.nextFloat()));
        }

        return tree;
    }

    public float getEuclideanDistance(float[] v1, float[] v2) {
        // TODO:
        return 0;
    }

    public float getCosineDistance(float[] v1, float[] v2) {
        // TODO:
        return 0;
    }

    public void printSpanningTree(OutputStream out, SpanningTree tree) {
        PrintStream fout = new PrintStream(new BufferedOutputStream(out));
        fout.println("digraph G {");

        for (Edge edge : tree.getEdges())
            fout.printf("\"%s\" -> \"%s\"[label=\"%5.4f\"];\n", words.get(edge.getSource()), words.get(edge.getTarget()), edge.getWeight());

        fout.println("}");
        fout.close();
    }

    static public void main(String[] args) throws Exception {
        final String INPUT_FILE = "/Users/jdchoi/Documents/EmoryNLP/cs571/vsm/word_vectors.txt";
        final String OUTPUT_FILE = "/Users/jdchoi/Documents/EmoryNLP/cs571/vsm/word_vectors.dot";

        MSTWord mst = new MSTWord();

        mst.readVectors(new FileInputStream(INPUT_FILE));
        SpanningTree tree = mst.findMinimumSpanningTree();
        mst.printSpanningTree(new FileOutputStream(OUTPUT_FILE), tree);
        System.out.println(tree.getTotalWeight());
    }
}
