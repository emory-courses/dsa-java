# Sort: Distribution-based

## Reading

* [Bucket sort](http://en.wikipedia.org/wiki/Bucket_sort).
* [Radix sort](http://en.wikipedia.org/wiki/Radix_sort).

## Exercise

* [Source codes](../tree/master/src/sort/distribution).
* [Unit tests](../tree/master/src/sort/test/SortTest.java).

## Quiz

* Create a class `MSDRadixSort` under [`sort.distribution`](../tree/master/src/sort/distribution) extending [`RadixSort`](../tree/master/src/sort/distribution/RadixSort.java).
* `MSDRadixSort` must sort the most significant digit first, the 2nd most significant digit next, and so on. Feel free to use the code in [`LSDRadixSort`](../tree/master/src/sort/distribution/LSDRadixSort.java).
* Run the [unit test](../tree/master/src/sort/test/SortTest.java) and make sure your sorting algorithms perform accurately.
* Compare the speed between `LSDRadixSort` and `MSDRadixSort` using the [unit test](../tree/master/src/sort/test/SortTest.java). Write a report about the speed comparison and save it as `quiz3.pdf`.
* Submit `MSDRadixSort.java` and `quiz3.pdf`: https://canvas.emory.edu/courses/32845/assignments/77471