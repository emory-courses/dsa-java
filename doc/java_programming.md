# Java Programming

This lecture gives an overview of Java Programming that is essential to understand the course materials.
> You are the owner of your program and it is important for you to know what every word means in your code. 

## Class

A class is a template to instantiate an object.
> What is the difference between "class" and "object"?

The following shows a typical code to create a Java file called [`Number.java`](../src/main/java/edu/emory/cs/number/Number.java):

```java
package edu.emory.cs.algebraic;

public class Number {

}
```

* `package`: indicates the name of the package (in hierarchy) that this class belongs to.
* [Access-level modifiers](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html): `public`, `protected`, _no modifier_, `private`
> What are the acceptable access-level modifiers to declare a top-level class?

Let us declare two methods, `add` and `multiply`, under `Number`:

```java
public class Number {
    /**
     * Adds `n` to this number.
     * @param n the number to be added.
     */
    public void add(Number n) {}

    /**
     * Multiplies `n` to this number.
     * @param n the number to be multiplied.
     */
    public void multiply(Number n) {}
}
```

* [Javadoc](https://docs.oracle.com/en/java/javase/14/docs/specs/javadoc/doc-comment-spec.html): @param

The problem is that we cannot define these methods unless we know what type of "number" this class implements; in other words, it is too abstrat to define the code
  




sd


 
