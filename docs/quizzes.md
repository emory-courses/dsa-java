# Quizzes

## Quiz 5

Let `L` be a list of country names in `String` where spaces are allowed (e.g., `"United States"`, `"South Korea"`).
Let `T` be a trie where all country names in `L` are inserted and each country name is assigned with a unique ID in `Integer` (see the [example](img/tries-2.png)).
Your task is to write a method that takes a string and finds all country names in the string using `T`.

* Pseudo-code
  * Write a pseudo-code that completes the `get_entities()` method in [`TrieQuiz`](../src/main/java/edu/emory/cs/trie/TrieQuiz.java#L31).
* Submission
  * Write a report including your pseudo-code and a brief explanation about the complexity of your method and save it as `quiz5.pdf`.
  * Submit `quiz5.pdf` to https://canvas.emory.edu/courses/62873/assignments/255742


## Quiz 6

Provide a graph example for which Prim's and Kruskal's algorithms generate different kinds of minimum spanning trees.  Explain how these trees are generated.  If you cannot find an example, explain why these algorithms always generate the same minimum spanning tree given any kind of graph.

* Submission
  * Write a report about your findings and save it as `quiz6.pdf`.
  * Submit your report to https://canvas.emory.edu/courses/62873/assignments/255743


## Quiz 7

What are the worst-case complexities of Prim's, Kruscal's and Chu–Liu-Edmonds’ algorithms when `V` is the number of vertices and `E` is the number of edges in a graph? Explain your answer.

* Submission
  * Write a report about your findings and save it as `quiz7.pdf`.
  * Submit your report to https://canvas.emory.edu/courses/62873/assignments/255744


## Quiz 8

What is the worst-case complexity of Dijkstra’s algorithm when `V` is the number of vertices and `E` is the number of edges in a graph? Explain your answer.

* Submission
  * Write a report about your findings and save it as `quiz8.pdf`.
  * Submit your report to https://canvas.emory.edu/courses/62873/assignments/255745


## Quiz 9

Unlike the [Ford–Fulkerson algorithm](https://en.wikipedia.org/wiki/Ford%E2%80%93Fulkerson_algorithm) that uses depth-first search to find augmenting paths, the [Edmonds–Karp algorithm](https://en.wikipedia.org/wiki/Edmonds%E2%80%93Karp_algorithm) uses breadth-first search to find augmenting paths.  What is the advantage of using the Edmonds–Karp algorithm over the Ford–Fulkerson algorithm?  Explain your answer.

* Submission
  * Write a report about your findings and save it as `quiz9.pdf`.
  * Submit your report to https://canvas.emory.edu/courses/62873/assignments/255746


## Quiz 10

For each k, how many times are the following methods called recursively?
* `RHanoi#solve(List<String> int, char, char, char)`.
* `DHanoi#solve(List<String>, int, char, char, char, Map<String,int[]>)`.

Is there any clear pattern between k and the number of the method calls in each class? Explain the pattern if there is one.

* Submission
  * Write a report about your findings and save it as `quiz10.pdf`.
  * Submit your report to https://canvas.emory.edu/courses/62873/assignments/255747
