# Sort: Comparison-based

## Reading

* [Selection sort](https://en.wikipedia.org/wiki/Selection_sort).
* [Insertion sort](https://en.wikipedia.org/wiki/Insertion_sort).
* [Heapsort](https://en.wikipedia.org/wiki/Heapsort).
* [Shellsort](https://en.wikipedia.org/wiki/Shellsort).

## Exercise

* [Source codes](../tree/master/src/sort/comparison).
* [Unit tests](../tree/master/src/sort/test).

## Quiz

* Create classes `ShellSortPratt` and `ShellSortHibbard` under [`sort.comparison`](../tree/master/src/sort/comparison) extending [`ShellSort`](../tree/master/src/sort/comparison/ShellSort.java).
* `ShellSortPratt` and `ShellSortHibbard` must use the Pratt and Hibbard sequences, respectively. Feel free to use the code in [`ShellSortKnuth`](../tree/master/src/sort/comparison/ShellSortKnuth.java):
 * Pratt: successive numbers of the form 2<sup><i>p</i></sup>3<sup><i>q</i></sup> (1, 2, 3, 4, 6, 8, 9, 12, ...)
 * Hibbard: 2<sup><i>k</i></sup> - 1 (1, 3, 7, 15, 31, 63, ...)
* Run the [unit test](../tree/master/src/sort/test/SortTest.java) and make sure your sorting algorithms perform accurately.
* Compare the speed between `ShellSortPratt`, `ShellSortHibbard`, and `ShellSortKnuth` using the [unit test](../tree/master/src/sort/test/SortTest.java). Write a report about the speed comparison and save it as `quiz2.pdf`.
* Submit `ShellSortPratt.java`, `ShellSortHibbard.java`, and `quiz2.pdf`: https://canvas.emory.edu/courses/32845/assignments/75152