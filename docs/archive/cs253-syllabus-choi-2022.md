# Data Structures and Algorithms in Java

This is an advanced programming course in computer science that teaches how to design efficient structures and algorithms to process big data and methods to benchmark their performance for large-scale computing.
Topics cover data structures such as _priority queues_, _binary trees_, _tries_, and _graphs_ as well as their applications in the construction of effective algorithms such as _sorting_, _searching_, _balancing_, _traversing_, and _spanning_.
Advanced topics such as _network flow_ and _dynamic programming_ are also discussed.
Throughout this course, students are expected to

* Have deep conceptual understanding in various data structures and algorithms.
* Implement their conceptual understanding in a programming language.
* Explore the most effective structures and algorithms for given tasks.
* Properly assess the quality of their implementations.

Intermediate-level of Java programming is a prerequisite of this course.
There are topical quizzes and homework assignments that require sufficient skills in Java programming, Git version control, Gradle software project management, and scientific writing.

## General

* Course webpage: https://github.com/emory-courses/dsa-java
* Class location: https://emory.zoom.us/j/92430843956
* Class hours: TuTh 2:30pm - 3:45pm
* Prerequisites: CS171 (or equivalent)

## Instructors

* [Jinho Choi](http://cs.emory.edu/~choi) <br>
  : Associate Professor of Computer Science <br>
  : Office Hours &rarr; TuTh 4pm - 5:30pm
* [Jessica Ji](https://www.linkedin.com/in/yuxin-jessica-ji/) <br>
  : Senior in QTM and Linguistics <br>
  : Office Hours &rarr; MW 9am - 10:30am
* [Leisheng Yu](https://www.linkedin.com/in/leisheng-yu-2419731a9/) <br>
  : Senior in CS and Applied Mathematics <br>
  : Office Hours &rarr; WF 2:30pm - 4:00pm
* Contact: _firstname.lastname_@emory.edu
* Zoom link to all office hours: https://emory.zoom.us/j/91473219159
* Please use [Issues](issue_guidelines.md) for questions and comments that can be shared publicly and use emails for private matters only.

## Textbook

* [Data Structured and Algorithms in Java](https://emory.gitbook.io/dsa-java/) (2022 Edition) by Jinho D. Choi

## Grading

* 1 + 9 topical quizzes: 70%
* 3 homework assignments: 30%

## Notes

* One quiz will be assigned for every topic to check if you keep up with the materials.
* Homework assignments aim to assess conceptual understanding, programming ability, and analytical writing skills.
* All quizzes and assignments must be submitted individually. Discussions are allowed; however, your work must be original.
* Late submissions within a week will be accepted with the grading penalty of 15%, and will not be accepted once the solutions are discussed in class.
* Your work is governed by the [Emory Honor Code](http://catalog.college.emory.edu/academic/policies-regulations/honor-code.html). Honor code violations (e.g., copies from any source including your colleagues and internet sites) will be referred to the [Emory Honor Council](http://college.emory.edu/oue/current-students/honor-council.html).
* Excuses for absence/reschedule and other serious personal events (health, family, personal related, etc.) that affect course performance must be accompanied by a letter from the [Office for Undergraduate Education](http://college.emory.edu/oue/current-students/advising.html).

## Schedule

| Date  |               Topic                |                                                                               Resource                                                                               |       Assignment        |
|:-----:|:----------------------------------:|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:-----------------------:|
| 01/11 |         0. Getting Started         |         [book](https://emory.gitbook.io/dsa-java/getting-started), [main](../src/main/java/edu/emory/cs/utils), [test](../src/test/java/edu/emory/cs/utils)          | [Quiz 0](quiz/quiz0.md) |
| 01/13 |         1. Java Essentials         |     [book](https://emory.gitbook.io/dsa-java/java-essentials), [main](../src/main/java/edu/emory/cs/algebraic), [test](../src/test/java/edu/emory/cs/algebraic)      |                         |
| 01/18 |         1. Java Essentials         |                                                                                                                                                                      |                         |
| 01/20 |         1. Java Essentials         |                                                                                                                                                                      | [Quiz 1](quiz/quiz1.md) |
| 01/25 |         2. Priority Queues         |         [book](https://emory.gitbook.io/dsa-java/priority-queues), [main](../src/main/java/edu/emory/cs/queue), [test](../src/test/java/edu/emory/cs/queue)          |                         |
| 01/27 |           **Moving Day**           |                                                                                                                                                                      |                         |
| 02/01 |         2. Priority Queues         |                                                                                                                                                                      |                         |
| 02/03 |         2. Priority Queues         |                                                                                                                                                                      |       [Quiz 2]()        |
| 02/08 |       3. Sorting Algorithms        |         [book](https://emory.gitbook.io/dsa-java/sorting-algorithms), [main](../src/main/java/edu/emory/cs/sort), [test](../src/test/java/edu/emory/cs/sort)         |                         |
| 02/10 |       3. Sorting Algorithms        |                                                                                                                                                                      |        [HW 1]()         |
| 02/15 |       3. Sorting Algorithms        |                                                                                                                                                                      |       [Quiz 3]()        |
| 02/17 |       4. Binary Search Trees       |        [book](https://emory.gitbook.io/dsa-java/binary-search-trees), [main](../src/main/java/edu/emory/cs/tree), [test](../src/test/java/edu/emory/cs/tree)         |                         | 
| 02/22 |       4. Binary Search Trees       |                                                                                                                                                                      |                         |
| 02/24 |       4. Binary Search Trees       |                                                                                                                                                                      |       [Quiz 4]()        |
| 03/01 |              5. Tries              |               [book](https://emory.gitbook.io/dsa-java/tries), [main](../src/main/java/edu/emory/cs/trie), [test](../src/test/java/edu/emory/cs/trie)                |                         |
| 03/03 |              5. Tries              |                                                                                                                                                                      |  [Quiz 5](), [HW 2]()   |
| 03/08 |          **Spring Break**          |                                                                                                                                                                      |                         |
| 03/10 |          **Spring Break**          |                                                                                                                                                                      |                         |
| 03/15 |          6. Disjoint Sets          |                                  [book](https://emory.gitbook.io/dsa-java/disjoint-sets), [main](../src/main/java/edu/emory/cs/set)                                  |                         |
| 03/17 |             7. Graphs              |              [book](https://emory.gitbook.io/dsa-java/graphs), [main](../src/main/java/edu/emory/cs/graph), [test](../src/test/java/edu/emory/cs/graph)              |                         |
| 03/22 |             7. Graphs              |                                                                                                                                                                      |       [Quiz 6]()        |
| 03/24 |     8. Minimum Spanning Trees      | [book](https://emory.gitbook.io/dsa-java/minimum-spanning-trees), [main](../src/main/java/edu/emory/cs/graph/span), [test](../src/test/java/edu/emory/cs/graph/span) |                         |
| 03/29 |     8. Minimum Spanning Trees      |                                                                                                                                                                      |        [HW 3]()         |
| 03/31 |     8. Minimum Spanning Trees      |                                                                                                                                                                      |       [Quiz 7]()        |
| 04/05 |          9. Network Flow           |      [book](https://emory.gitbook.io/dsa-java/network-flow), [main](../src/main/java/edu/emory/cs/graph/flow), [test](../src/test/java/edu/emory/cs/graph/flow)      |                         |
| 04/07 |          9. Network Flow           |                                                                                                                                                                      |                         |
| 04/12 |          9. Network Flow           |                                                                                                                                                                      |       [Quiz 8]()        |
| 04/14 |      10. Dynamic Programming       |     [book](https://emory.gitbook.io/dsa-java/dynamic-programming), [main](../src/main/java/edu/emory/cs/dynamic), [test](../src/test/java/edu/emory/cs/dynamic)      |                         |
| 04/19 |      10. Dynamic Programming       |                                                                                                                                                                      |       [Quiz 9]()        |
| 04/21 |             **Review**             |                                                                                                                                                                      |                         |

<!--  -->
<!-- Shortest Path Algorithms]() | [md, [pdf](shortest_path_algorithms.pdf), [main](../src/main/java/edu/emory/cs/graph/path/) | [quiz 8](quiz0.md#quiz-8) | -->
<!-- HW1: 2/24, HW2: 3/22, HW3: 4/14  -->
