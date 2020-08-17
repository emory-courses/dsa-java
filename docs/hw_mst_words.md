# Homework 3

## Vector Space Model

Your task is to apply minimum spanning tree algorithms to cluster similar words together in vector space.

## Preparation

* Download [`MSTWord`](../src/main/java/edu/emory/cs/graph/span/MSTWord.java) and put it under the [`graph.span`](../src/main/java/edu/emory/cs/graph/span/) package.
* Download [`word_vectors.txt`](../src/main/resources/word_vectors.txt) and put it under the [resources](../src/main/resources/) directory.  Each line consists of a word and its vector representation.  For instance, the first line consists of the word "_New_" (0'th column) and its vector representation (1st - 50th columns) such that every word is represented by a 50-dimensional vector.

## Task

* Create the `MSTWordLastname` class (e.g., [`MSTWordChoi`](../src/main/java/edu/emory/cs/graph/span/MSTWordChoi.java)) and put it under the [`graph.span`](../src/main/java/edu/emory/cs/graph/span/) package.
   * This class must extend the abstract class [`MSTWord`](../src/main/java/edu/emory/cs/graph/span/MSTWord.java).
* Override the `createGraph()` method, called by the constructor, that generates a [complete graph](https://en.wikipedia.org/wiki/Complete_graph) such that
   * Each vertex in the graph is a word vector.
   * The edge weight between every vertex pair is measured by the [cosine distance](https://en.wikipedia.org/wiki/Cosine_similarity) between the two corresponding word vectors (cosine distance = 1 - consine similarity)
* Override the `getMinimumSpanningTree()` method that finds a minimum spanning tree from the complete graph.
   * Run the `main()` method in [`MSTWordChoi`](../src/main/java/edu/emory/cs/graph/span/MSTWordChoi.java) and save the `word_vectors.dot` file.
* Override the `getShortestPath()` method that finds the shortest path between the source and the target vertices.
   * The shortest path is represented by a list of string where the first and the last strings are the source and the target words respectively and the others represent the intermediate words along with the shortest path.

## Submission

* Use [GraphvizOnline](https://dreampuf.github.io/GraphvizOnline/) to visualize the `word_vectors.dot` file, save the output as the PNG file `word_vectors.png`, and put it under the [resources](../src/main/resources/) directory.
* Make sure to commit and push all the updates to your Github including `word_vectors.png` and `MSTWordLastname.java`.
