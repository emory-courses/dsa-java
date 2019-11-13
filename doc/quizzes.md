# Quizzes

## Quiz 0

* Follow the instructions in [Getting Started](getting_started.md).
* Make sure your Github repository includes the following classes with required contents:
  *  [`src/main/java/edu/emory/cs/utils/Utils.java`](../src/main/java/edu/emory/cs/utils/Utils.java).
  *  [`src/test/java/edu/emory/cs/utils/UtilsTest.java`](../src/test/java/edu/emory/cs/utils/UtilsTest.java).
* Submit the followings to https://canvas.emory.edu/courses/62873/assignments/253603
  * URL to your Github repository (e.g., https://github.com/your_id/cs253).
  * Java archive: `cs253-1.0-SNAPSHOT.jar`.

## Quiz 1

* Implementation
  * Create the class `TernaryHeap` under the [`queue`](../src/main/java/edu/emory/cs/queue/) package extending the abstract class [`AbstractPriorityQueue`](../src/main/java/edu/emory/cs/queue/AbstractPriorityQueue.java).
  * Each node in `TernaryHeap` must take up to 3 children (so it becomes a ternary instead of binary tree).
  * Feel free to use the code in [`BinaryHeap`](../src/main/java/edu/emory/cs/queue/BinaryHeap.java).
* Unit Tests
  * Add the following method, `testTernaryHeap()`, under the [`PriorityQueueTest`](../src/test/java/edu/emory/cs/queue/PriorityQueueTest.java) class and run it to make sure your heap performs accurately.
    ```java
    @Test
    public void testTernaryHeap() {
        List<Integer> keys = List.of(4, 1, 3, 2, 5, 6, 8, 3, 4, 7, 5, 9, 7);
        testAccuracy(new TernaryHeap<>(), Comparator.reverseOrder(), new ArrayList<>(keys));
        testAccuracy(new TernaryHeap<Integer>(Comparator.reverseOrder()), Comparator.naturalOrder(), new ArrayList<>(keys));
    }
    ```
  * Compare speeds between `TernaryHeap` and `BinaryHeap` for both the `add` and `remove` operations using [`PriorityQueueTest#testSpeed()`](../tree/master/src/queue/PriorityQueueTest.java).
  * Write a report about the speed comparisons and save it to `quiz1.pdf`.
* Submission
  * Commit and push all the updates to your Github repository.
  * Submit `quiz1.pdf` to https://canvas.emory.edu/courses/62873/assignments/255722

## Quiz 2

* Implementation
  * Create the classes `ShellSortPratt` and `ShellSortHibbard` under [`sort.comparison`](../src/main/java/edu/emory/cs/sort/comparison) extending [`ShellSort`](../src/main/java/edu/emory/cs/sort/comparison/ShellSort.java).
  * `ShellSortPratt` and `ShellSortHibbard` must use the Pratt and Hibbard sequences, respectively.
    * Pratt: successive numbers of the form 2<sup><i>p</i></sup>3<sup><i>q</i></sup> (1, 2, 3, 4, 6, 8, 9, 12, ...).
    * Hibbard: 2<sup><i>k</i></sup> - 1 (1, 3, 7, 15, 31, 63, ...).
  * Feel free to use the code in [`ShellSortKnuth`](../src/main/java/edu/emory/cs/sort/comparison/ShellSortKnuth.java).
* Unit Tests
  * Run the [unit test](../src/test/java/edu/emory/cs/sort/SortTest.java) and make sure your sorting algorithms perform accurately.
  * Compare the speeds between `ShellSortPratt`, `ShellSortHibbard`, and `ShellSortKnuth` using the [unit test](../src/test/java/edu/emory/cs/sort/SortTest.java).
  * Write a report about the speed comparison and save it as `quiz2.pdf`.
* Submission
  * Commit and push all the updates to your Github repository.
  * Submit `quiz2.pdf` to https://canvas.emory.edu/courses/62873/assignments/255739


## Quiz 3

* Implementation
  * Create the class `MSDRadixSort` under [`sort.distribution`](../src/main/java/edu/emory/cs/sort/distribution) extending [`RadixSort`](../src/main/java/edu/emory/cs/sort/distribution/RadixSort.java) or any of its super class including [`BucketSort`](../src/main/java/edu/emory/cs/sort/distribution/BucketSort.java) and [`AbstractSort`](../src/main/java/edu/emory/cs/sort/AbstractSort.java).
  * `MSDRadixSort` must sort the most significant digit first, the 2nd most significant digit next, and so on.
  * Feel free to use the code in [`sort.distribution`](../src/main/java/edu/emory/cs/sort/distribution/).
* Unit Tests
  * Run the [unit test](../src/test/java/edu/emory/cs/sort/SortTest.java) and make sure your sorting algorithms perform accurately.
  * Compare the speed between `LSDRadixSort` and `MSDRadixSort` using the [unit test](../src/test/java/edu/emory/cs/sort/SortTest.java).
  * Write a report about the speed comparison and save it as `quiz3.pdf`.
* Submission
  * Commit and push all the updates to your Github repository.
  * Submit `quiz3.pdf` to https://canvas.emory.edu/courses/62873/assignments/255740


## Quiz 4

* Interpretation
  * Explain how the `remove()` method works in [`AbstractBalancedBinarySearchTree`](../src/main/java/edu/emory/cs/tree/balanced/AbstractBalancedBinarySearchTree.java#L33):
  * Explain what gets assigned to `lowest` in [line 37](../src/main/java/edu/emory/cs/tree/balanced/AbstractBalancedBinarySearchTree.java#L37).
  * Explain how the `balance()` method in [`AVLTree`](../src/main/java/edu/emory/cs/tree/balanced/AVLTree.java#L41) and [`RedBlackTree`](../src/main/java/edu/emory/cs/tree/balanced/RedBlackTree.java#L28) keeps the tree in balance (or not in balance) after a removal.
* Submission
  * Write a report about your explanation and save it as `quiz4.pdf`.
  * Submit `quiz4.pdf` to https://canvas.emory.edu/courses/62873/assignments/255741


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

