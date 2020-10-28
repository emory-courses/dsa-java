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

import edu.emory.cs.graph.Graph;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

public class MSTWordHW extends MSTWord {
    public MSTWordHW(InputStream in) {
        super(in);
    }

    @Override
    protected Graph createGraph() {
        // TODO: to be filled
        return null;
    }

    @Override
    public SpanningTree getMinimumSpanningTree() {
        // TODO: to be filled
        return null;
    }

    @Override
    public List<String> getShortestPath(int source, int target) {
        return null;
    }

    static public void main(String[] args) throws Exception {
        final String INPUT_FILE = "src/main/resources/word_vectors.txt";
        final String OUTPUT_FILE = "src/main/resources/word_vectors.dot";

        MSTWord mst = new MSTWordHW(new FileInputStream(INPUT_FILE));
        SpanningTree tree = mst.getMinimumSpanningTree();
        mst.printSpanningTree(new FileOutputStream(OUTPUT_FILE), tree);
        System.out.println(tree.getTotalWeight());
    }
}
