# Java Programming

This lecture gives an overview of Java Programming that is essential to understand the course materials.
> You are the owner of your program and it is important for you to know what every word means in your code. 

## Class

A class is a template to instantiate an object.
> What is the difference between "class" and "object"?

The following shows a typical code to create a Java file called [`Ring.java`](../src/main/java/edu/emory/cs/number/Ring.java)

```java
package edu.emory.cs.algebraic;

public class Ring {

}
```

* `package`: indicates the name of the package (in hierarchy) that this class belongs to. 
* [Access-level modifiers](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html): `public`, `protected`, _no modifier_, `private`.
> What are the acceptable access-level modifiers to declare a top-level class?

A [ring](https://en.wikipedia.org/wiki/Ring_(mathematics)) is an algebraic structure that consists of a set equipped with two binary operations, addition and multiplication.
Let us add the 
