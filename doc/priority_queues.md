# Priority Queues

## Reading

* [Priority queue](https://en.wikipedia.org/wiki/Priority_queue).
* [Binary heap](https://en.wikipedia.org/wiki/Binary_heap).

## Exercise

* [Source codes](../tree/master/src/queue).
* [Unit tests](../tree/master/src/queue/test/PriorityQueueTest.java).

## Quiz

* Create a class `TernaryHeap` under [`queue`](../tree/master/src/queue) extending the abstract class [`AbstractPriorityQueue`](../tree/master/src/queue/AbstractPriorityQueue.java).
* Each node in `TernaryHeap` must take at most 3 children instead of 2 (so it becomes a ternary instead of binary tree). Feel free to use the code in [`BinaryHeap`](../tree/master/src/queue/BinaryHeap.java).
* Run the [unit test](../tree/master/src/queue/PriorityQueueTest.java) and make sure your heap performs accurately.
* Compare the speed between `TernaryHeap` and `BinaryHeap` for both the `add` and `remove` operations using the [unit test](../tree/master/src/queue/PriorityQueueTest.java). Write a report about the speed comparison and save it as `quiz1.pdf`.
* Submit `TernaryHeap.java` and `quiz1.pdf`: https://canvas.emory.edu/courses/32845/assignments/73020