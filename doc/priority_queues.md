---
marp: true
paginate: true
---

# Priority Queues

## Contents

* [Abstract Priority Queue](#abstract-priority-queue).
* [Lazy Priority Queue](#lazy-priority-queue).
* [Eager Priority Queue](#eager-priority-queue).
* [Binary Heap](#binary-heap).

---

## Abstract Priority Queue

Source: [`AbstractPriorityQueue.java`](../src/main/java/edu/emory/cs/queue/AbstractPriorityQueue.java)

```java
public abstract class AbstractPriorityQueue<T extends Comparable<T>> {
    protected Comparator<T> comparator;

    public AbstractPriorityQueue(Comparator<T> comparator) {
        this.comparator = comparator;
    }
```

* Class types: `class` vs. `abstract class` vs. `interface`.
* Generics: `<T extends Comparable<T>>`.
* Member types: `private` vs. `package` vs. `protected` vs. `public`.
* Constructor: `this`.

---

```java
    /**
     * Adds a comparable key to this queue.
     * @param key the comparable key.
     */
    abstract public void add(T key);

    /**
     * Removes the key with the highest priority if exists.
     * @return the key with the highest priority if exists; otherwise, {@code null}.
     */
    abstract protected T remove();

    /**
     * @return the size of this queue.
     */
    abstract public int size();
```  

* Abstract methods: `add()`, `remove()`, `size()`.
* Javadoc.

---


```java
    /**
     * @return {@code true} if the queue is empty; otherwise, {@code false}.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
}
```  
* Regular method: `isEmpty()`.

---

## Lazy Priority Queue

Source: [`LazyPriorityQueue.java`](../src/main/java/edu/emory/cs/queue/LazyPriorityQueue.java)

```java
public class LazyPriorityQueue<T extends Comparable<T>> extends AbstractPriorityQueue<T> {
    private List<T> keys;

    public LazyPriorityQueue(Comparator<T> comparator) {
        super(comparator);
        keys = new ArrayList<>();
    }

    public LazyPriorityQueue() {
        this(Comparator.naturalOrder());
    }
```

* Inheritance: `extends AbstractPriorityQueue<T>`.
* Constructors: default vs. parameters, `this` vs. `super`.

---

```java
    /**
     * Adds a key to the back of the list.
     * @param key the comparable key.
     */
    @Override
    public void add(T key) {
        keys.add(key);
    }

    @Override
    public int size() {
        return keys.size();
    }
```

* Annotation: [`@Override`](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/Override.html).
* Complexity: `add()`.

---

```java
    /**
     * Finds the key with the highest priority, and removes it from the list.
     * @return the key with the highest priority if exists; otherwise, {@code null}.
     */
    @Override
    protected T remove() {
        if (isEmpty()) return null;
        T max = Collections.max(keys, comparator);
        keys.remove(max);
        return max;
    }
```

* Edge case handling: `remove()`.
* Standard API: [`Collections.max()`](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Collections.html#max(java.util.Collection,java.util.Comparator)).
* Complexity: `remove()`.

---

## Eager Priority Queue

Source: [`EagerPriorityQueue.java`](../src/main/java/edu/emory/cs/queue/EagerPriorityQueue.java)

```java
    /**
     * Adds a key to the list according to the priority.
     * @param key the comparable key.
     */
    @Override
    public void add(T key) {
        int index = Collections.binarySearch(keys, key, comparator);
        if (index < 0) index = -(index + 1);
        keys.add(index, key);
    }
```

* Standard API: [Collections.binarySearch()](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Collections.html#binarySearch(java.util.List,T,java.util.Comparator)).
* Complexity: `add()`.

---

```java
    /**
     * Remove the last key in the list.
     * @return the key with the highest priority if exists; otherwise, {@code null}.
     */
    @Override
    protected T remove() {
        return isEmpty() ? null : keys.remove(keys.size() - 1);
    }
```

* Ternary conditional operator: `condition ? : `.
* Complexity: `remove()`.

---

## Binary Heap

### What is a heap?

* A tree where the key of each node has a higher or equal priority than its children.
* The tree is guaranteed to be balanced.
* What is a binary heap?

### Operations
* Add: swim.
* Remove: sink.
* Both operations can be done in O(log n).

---

![](img/priority_queues-0.png)


* Binary heap can be represented by a list.
* Index of the parent: $k / 2$
* Index of the children: $k*2$ and $(k*2) + 1$


---

* Source: [`BinaryHeap.java`](../src/main/java/edu/emory/cs/queue/BinaryHeap.java)


Binary heap using a list


---

## References

* [Priority queue](https://en.wikipedia.org/wiki/Priority_queue).
* [Binary heap](https://en.wikipedia.org/wiki/Binary_heap).
* [Generics in Java](https://en.wikipedia.org/wiki/Generics_in_Java).

