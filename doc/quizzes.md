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