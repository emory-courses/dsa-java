package edu.emory.cs.graph.span;

import edu.emory.cs.graph.Graph;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

public class MSTWordChoi extends MSTWord {
    public MSTWordChoi(InputStream in) {
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

        MSTWord mst = new MSTWordChoi(new FileInputStream(INPUT_FILE));
        SpanningTree tree = mst.getMinimumSpanningTree();
        mst.printSpanningTree(new FileOutputStream(OUTPUT_FILE), tree);
        System.out.println(tree.getTotalWeight());
    }
}
