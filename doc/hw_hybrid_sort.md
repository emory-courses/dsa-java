# Homework 1

## Hybrid Sort

Your task is to write a program that sorts a 2D-array of comparable keys into an 1D-array where all the keys are sorted in ascending order. Here is a sample input to your program:

```java
Integer[][] input = {{0,  1,  2,  3},
                     {7,  6,  5,  4},
                     {0,  3,  1,  2},
                     {4,  7,  6,  5},
                     {9,  8, 11, 10}};
```

Here is the expected output given the sample input:

```java
[0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 9, 10, 11]
```

Each row in the input array has one of the following properties:
* Sorted in ascending order (e.g., the 1st row).
* Sorted in descending order (e.g., the 2nd row).
* Mostly sorted in ascending order (e.g., the 3rd row).
* Mostly sorted in descending order (e.g., the 4th row).
* Randomly distributed (e.g., the 5th row).

Perhaps, the easiest way is to merge all rows in the input array into an 1D-array then sort it. The implementation of this strategy is provided to establish the baseline: [`HybridSortChoi`](../src/main/java/edu/emory/cs/sort/hybrid/HybridSortChoi.java). Your goal is to design a sorting mechanism that gives a noticeable speed-up over this baseline.

## Task

* Create a class `HybridSortLastname` (e.g., `HybridSortChoi`) implementing the interface [`HybridSort`](../src/main/java/edu/emory/cs/sort/hybrid/HybridSort.java) under the package [`hybridsort`](../src/main/java/edu/emory/cs/sort/hybrid/).
* Override the `sort` method and test your program for accuracy and speed using [`HybridSortTest`](../tree/master/src/sort/hybrid/HybridSortTest.java). Try different input arrays; you are responsible for the robustness of your program. Also, try different configurations for the speed comparison (e.g., row size, column size, shuffle ratio).
* Write the report `hw1.pdf` describing the logic behind your mechanism and the speed comparison against the baseline.
* Submit `HybridSortLastname.java` and `hw1.pdf` to https://canvas.emory.edu/courses/62873/assignments/255736

## Note

* You are not allowed to use any of the java built-in sorting methods.
* There can be any arbitrary number of rows in the input array, where each row meets any of the 5 conditions above.
* The size of each row can vary.
