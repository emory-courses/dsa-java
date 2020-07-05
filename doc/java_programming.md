# Java Programming

This lecture gives an overview of Java Programming that is essential to understand the course materials.
> You are the owner of your program and it is important for you to know what every word means in your code. 

## Contents

* [Class](#class)
* [Interface](#interface)
* [Abstract Class](#abstract-class)

----
## Class

A class is a template to instantiate an object.
> What is the difference between "class" and "object"?

Let us create a new class called [`Numeral`](../src/main/java/edu/emory/cs/algebraic/Numeral.java) that we want to be a super class of all numeral types defined later:

```java
package edu.emory.cs.algebraic;

public class Numeral {

}
```

* `package`: indicates the name of the package (in hierarchy) that this class belongs to.
* [Access-level modifiers](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html): `public`, `protected`, _no modifier_, `private`
> What are the acceptable access-level modifiers to declare a top-level class?

Let us declare two methods, `add` and `multiply`, that are expected by all numeral types:

```java
public class Numeral {
    /**
     * Adds `n` to this numeral.
     * @param n the numeral to be added.
     */
    public void add(Numeral n) {
        // nothing you can do
    }

    /**
     * Multiplies `n` to this numeral.
     * @param n the numeral to be multiplied.
     */
    public void multiply(Numeral n) {
        // nothing you can do
     }
}
```

* [Javadoc](https://docs.oracle.com/en/java/javase/14/docs/specs/javadoc/doc-comment-spec.html): @param

The problem is that we cannot define the methods unless we know what numeral type this class implements; in other words, it is too abstract to define those methods.
Thus, we need to declare `Numeral` as an abstract class type.
> Would you be able to define these methods if the class was assumed to be a specific numeral type such as integer or double?

----
## Interface

There are two types of [abstract classes](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html) in Java, `abstract class` and `interface`.
> Can an object be instantiated by an abstract class or an interface?

Let us define `Numeral` as an interface:

```java
public interface Numeral {
    /**
     * Adds `n` to this numeral.
     * @param n the numeral to be added.
     */
    void add(Numeral n);

    /**
     * Multiplies `n` to this numeral.
     * @param n the numeral to be multiplied.
     */
    void multiply(Numeral n);
}
```

* All methods in an interface have the access-level of `public` that does not need to be explicitly coded.
* Abstract methods in an interface are declared without their bodies.
> Who defines the abstract methods then?

Let us create a new interface called [`SignedNumeral`](../src/main/java/edu/emory/cs/algebraic/SignedNumeral.java) that includes few more methods related to sign:

```java
public interface SignedNumeral extends Numeral {
    /**
     * Flips the sign of this numeral.
     */
    void flipSign();

    /**
     * Subtracts `n` from this numeral.
     * @param n the numeral to be subtracted.
     */
    default void subtract(Numeral n) {
        n.flipSign();
        add(n);
        n.flipSign();
    }
}
```

* `extends`: inherits exactly one class or interface.
* `default`: allows an interface to define a method with its body (introduced in [Java 8](https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html)).
> Can an interface inherit either an abstract class or a regular class?

Although the logic of `subtract()` seems to be correct, `n.flipSign()` gives a compile error because `n` is a type of `Numeral` that does not include the method `flipSign()`, which is defined in `SignedNumeral` that is a subclass of `Numeral`.
> What kind of a compile error does `n.flipSign()` give?


----
## Casting

There are two ways of handling this error.
One is to downcast the type of `n` to `SignedNumeral`, which makes the compiler think that it has the method `flipSign()`:

```java
default void subtract(Numeral n) {
    ((SignedNumeral)n).flipSign();
    add(n);
    ((SignedNumeral)n).flipSign();
}
```

This removes the compile error; however, it will likely cause a worse kind of error called _runtime error_.
> Why is a runtime error worse than a compile error?

Downcasting, although allowed in Java, is generally not recommended unless there is no other way of accomplishing the logic without using it.
Luckily, there is another way of handling this 




* add accepts Numeral
* 

what about add and multiply
how many abstract methods are in this interface?


## Generic

----
## Abstract Class


implements
multiple inheritance


<!-- Updated java_programming.md -->


> What are other types of methods allowed in an [interface](https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html)?<br>
> Can an interface have a member instance?



Comparable to Numeral