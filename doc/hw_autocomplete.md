# Homework 2

## Auto-Complete

Most virtual keyboards provide the option of auto-complete, which gives a list of candidate words that you wish to type given a prefix you enter.
For instance, when you type "sh", it gives a list of candidate words such as "she", "shell", "ship", etc.

```
"sh" -> ["she", "ship", "shell, ...]
```

If you select a word from the candidates, it should learn your selection as the top candidate for that prefix.
For instance, if you select "ship" from the example above, the next time you enter the same prefix "sh", it should give a list of candidates where the first item is "ship" instead of "she".

```
"sh" -> ["ship", "she", "shell, ...]
```

Your task is to write a program that gives a list of candidate words for any prefix and learns the selected candidates.


## Task

* Create a class called `AutocompleteLastname` (e.g., [`AutocompleteChoi`](../src/main/java/edu/emory/cs/trie/autocomplete/AutocompleteChoi.java)).
   * This class extends the abstract class [`Autocomplete`](../src/main/java/edu/emory/cs/trie/autocomplete/Autocomplete.java), which extends [`Trie`](../src/main/java/edu/emory/cs/trie/Trie.java).
   * The value type of the generic `T` can be a collection of strings (e.g., `List<String>`).
   * You must create a constructor that takes two parameters, `dict_file` and `max`, and calls its [super constructor](../src/main/java/edu/emory/cs/trie/autocomplete/Autocomplete.java#L33), which reads all words in the dictionary file (e.g., [`dict.txt`](../src/main/resources/dict.txt)).
* Override the `getCandidates()` method that takes a prefix and returns a list of candidate words matching the prefix.
   * The maximum number of candidates in the list must be the return value of the `getMax()` method.
   * The most recently selected candidate should appear as the 1st item, the 2nd most recently selected candidate should  appear as the 2nd item, and so on.
   * The rest of the candidate list should be filled with the shortest words matching the prefix.
   * If there are more than one candidate with the same lengths, they should be sorted alphabetically.
   * Make sure the same candidate does not appear more than once.
* Override the `pickCandidate()` method that takes a prefix and a selected candidate, and saves the information.
   * This is the most recently selected candidate for that particular prefix. It must appear as the first item in the candidate list when the same prefix is entered next time.
* Submit `AutocompleteLastname.java`: https://canvas.emory.edu/courses/62873/assignments/255737


## Extra credit

* Instead of showing the most recent candidates at the top, show the most frequently used candidates first.  This will require you to change the value type of the trie from `List<String>` to `List<something else>`.


## Notes

* Do not change the dictionary file.  If you find anything peculiar about the dictionary file, please let me know so everyone works on the same copy of the dictionary file.
* Please test your program yourself.  We will evaluate your program using our unit tests and measure the performance (both speed and accuracy).
* Take a look at [Map](http://docs.oracle.com/javase/7/docs/api/java/util/Map.html) if you are not familiar with methods in the standard library.
* If you are having trouble with implementing `getCandidates()`, think about how to traverse the trie given any node.
* If you are having trouble with implementing `pickCandidate()`, take a look at [`Trie#put`](../src/main/java/edu/emory/cs/trie/Trie.java#L44).
* You are not allowed to use any type of [Map](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Map.html) to store candidates for this homework.
* Your program should be able to handle prefixes or candidates that do not exist in the dictionary.
* All picked candidates must be treated as real words.
* Whitespaces are not allowed as input. You should trim all input strings.
