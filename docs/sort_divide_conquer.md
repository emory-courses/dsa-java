---
marp: true
theme: cs253-theme
paginate: true
---

# Sort: Divide and Conquer

## Contents

* [Divide and Conquer](#divide-and-conquer).
* [Merge Sort](#merge-sort).
* [Quick Sort](#quick-sort).
* [Intro Sort](#intro-sort).
* [Benchmarks](#benchmarks).
* [References](#references).

---

## Divide and Conquer

* _Divide_ the problem into _sub_-problems (recursively).
* _Conquer_ sub-problems, which effectively solves the _super_ problem.
<br>

|         | Merge         | Tim           | Quick         | Intro         |
|:-------:|:-------------:|:-------------:|:-------------:|:-------------:|
| Best    | $O(n \log n)$ | $O(n)$        | $O(n \log n)$ | $O(n \log n)$ |
| Worst   | $O(n \log n)$ | $O(n \log n)$ | $O(n \log n)$ | $O(n \log n)$ |
| Average | $O(n \log n)$ | $O(n \log n)$ | $O(n^2)$      | $O(n \log n)$ |
<br>

* Why do people ever want to use `QuickSort` then?

---

## Merge Sort

* _Divide_ a list into two sub-lists.
* Merge sub-lists into a super list in which all keys are _sorted_.

Source: [`MergeSort.java`](../src/main/java/edu/emory/cs/sort/divide_conquer/MergeSort.java)

```java
public class MergeSort<T extends Comparable<T>> extends AbstractSort<T> {
    private T[] temp;

    @Override
    public void sort(T[] array, int beginIndex, int endIndex) {
        if (beginIndex + 1 >= endIndex) return;
        int middleIndex = Utils.getMiddleIndex(beginIndex, endIndex);

        // sort left partition
        sort(array, beginIndex, middleIndex);
        // sort Right partition
        sort(array, middleIndex, endIndex);
        // merge partitions
        merge(array, beginIndex, middleIndex, endIndex);
    }
```

* Backup array: `T[] temp`.
* Static method: `Utils.getMiddleIndex()`.

---

```java
private void copy(T[] array, int beginIndex, int endIndex) {
    int N = array.length;

    if (temp == null || temp.length < N)
        temp = Arrays.copyOf(array, N);
    else {
        N = endIndex - beginIndex;
        System.arraycopy(array, beginIndex, temp, beginIndex, N);
    }

    assignments += N;
}
```

* Base API: `Arrays.copyOf()` vs. `System.arraycopy()`.
* How often does the backup array `temp` get created?
* How many values are assigned to `temp`?

---

```java
/**
 * @param beginIndex  the beginning index of the 1st half (inclusive).
 * @param middleIndex the ending index of the 1st half (exclusive).
 * @param endIndex    the ending index of the 2nd half (exclusive).
 */
 private void merge(T[] array, int beginIndex, int middleIndex, int endIndex) {
     int fst = beginIndex, snd = middleIndex;
     copy(array, beginIndex, endIndex);
     
     for (int k = beginIndex; k < endIndex; k++) {
         if (fst >= middleIndex)                    // no key left in the 1st half
             assign(array, k, temp[snd++]);
         else if (snd >= endIndex)                  // no key left in the 2nd half
             assign(array, k, temp[fst++]);
         else if (compareTo(temp, fst, snd) < 0)    // 1st key < 2nd key
             assign(array, k, temp[fst++]);
         else
             assign(array, k, temp[snd++]);
     }
}
```

* How many _comparisons_ and _assignments_?
* Can we reduce the number of _assignments_?

---

## Quick Sort

* Pick a _pivot_ key in a list.
* _Exchange_ keys between left and right partitions such that all keys in the left and right partitions are smaller or bigger than the pivot key, respectively.
* Repeat this procedure in each _partition_, recursively.

Source: [`QuickSort.java`](../src/main/java/edu/emory/cs/sort/divide_conquer/QuickSort.java)

```java
@Override
public void sort(T[] array, int beginIndex, int endIndex) {
    // at least one key in the range
    if (beginIndex >= endIndex) return;

    int pivotIndex = partition(array, beginIndex, endIndex);
    // sort left partition
    sort(array, beginIndex, pivotIndex);
    // sort right partition
    sort(array, pivotIndex + 1, endIndex);
}
```

---

```java
protected int partition(T[] array, int beginIndex, int endIndex) {
    int fst = beginIndex, snd = endIndex;

    while (true) {
        // Find where endIndex > fst > pivot
        while (++fst < endIndex && compareTo(array, beginIndex, fst) >= 0);
        // Find where beginIndex < snd < pivot
        while (--snd > beginIndex && compareTo(array, beginIndex, snd) <= 0);
        // pointers crossed
        if (fst >= snd) break;
        // exchange
        swap(array, fst, snd);
    }

    // set pivot
    swap(array, beginIndex, snd);
    return snd;
}
```

---

## Intro Sort

* Quicksort is the fastest _on average_.
* The worse-case complexity of Quicksort is _$O(n^2)$_.
* $\exists$ sorting algorithms with _faster_ worst-case complexities _than_ Quicksort.
* Quicksort for _random_ cases and a different algorithm for the _worst_ case.
* How to determine if Quicksort is meeting the _worst-case_?

---

Source: [`IntroSort.java`](../src/main/java/edu/emory/cs/sort/divide_conquer/IntroSort.java)

```java
public class IntroSort<T extends Comparable<T>> extends QuickSort<T> {
    private AbstractSort<T> engine;

    public IntroSort(AbstractSort<T> engine, Comparator<T> comparator) {
        super(comparator);
        this.engine = engine;
    }

    @Override
    public void resetCounts() {
        super.resetCounts();
        if (engine != null) engine.resetCounts();
    }
```

* `engine` must guarantee _$O(n \log n)$_.
* Benchmark: `resetCount()` recursive call?

---

```java
@Override
public void sort(T[] array, int beginIndex, int endIndex) {
    final int maxdepth = getMaxDepth(beginIndex, endIndex);
    introsort(array, beginIndex, endIndex, maxdepth);
    comparisons += engine.getComparisonCount();
    assignments += engine.getAssignmentCount();
}

protected int getMaxDepth(int beginIndex, int endIndex) {
    return 2 * (int) Utils.log2(endIndex - beginIndex);
}

private void introsort(T[] array, int beginIndex, int endIndex, int maxdepth) {
    if (beginIndex >= endIndex) return;

    if (maxdepth == 0)    // encounter the worst case
        engine.sort(array, beginIndex, endIndex);
    else {
        int pivotIndex = partition(array, beginIndex, endIndex);
        introsort(array, beginIndex, pivotIndex, maxdepth - 1);
        introsort(array, pivotIndex + 1, endIndex, maxdepth - 1);
    }
}
```

* Estimate the _partition depth_ that can lead to the worst case.
* Switch to another algorithm when it encounters the _worst case_.

---

## Benchmarks

### Number of Comparisons (Random)

<br>![height:20em](img/sort_divide_conquer-0.png)

---

### Number of Comparisons (Random)

<br>![height:20em](img/sort_divide_conquer-1.png)

---

### Number of Assignments (Random)

<br>![height:20em](img/sort_divide_conquer-2.png)

---

### Number of Assignments (Random)

<br>![height:20em](img/sort_divide_conquer-3.png)

---

### Speed Comparison (Random)

<br>![height:20em](img/sort_divide_conquer-4.png)

---

### Speed Comparison (Random)

<br>![height:20em](img/sort_divide_conquer-5.png)

---

### Speed Comparison (Ascending)

<br>![height:20em](img/sort_divide_conquer-6.png)

---

### Speed Comparison (Ascending)

<br>![height:20em](img/sort_divide_conquer-7.png)

---

### Speed Comparison (Descending)

<br>![height:20em](img/sort_divide_conquer-8.png)

---

### Speed Comparison (Descending)

<br>![height:20em](img/sort_divide_conquer-9.png)

---

## References

* [Mergesort](https://en.wikipedia.org/wiki/Merge_sort).
* [Quicksort](https://en.wikipedia.org/wiki/Quicksort).
* [Introsort](https://en.wikipedia.org/wiki/Introsort).
* [Timsort](https://en.wikipedia.org/wiki/Timsort).
 