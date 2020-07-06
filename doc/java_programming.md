# Java Programming

This lecture gives an overview of Java Programming that is essential to understand the course materials.
> You are the owner of your program and it is important for you to know what every word means in your code. 

## Contents

1. [Class](#class)
1. [Interface](#interface)
1. [Casting](#casting)
1. [Polymorphism](#polymorphism)
1. [Generics](#generics)
1. [Enum](#enum)
1. [Abstract Class](#abstract-class)

## Author

* [Jinho D. Choi](http://www.cs.emory.edu/~choi)

----
## 1. Class

A class is a template to instantiate an object.
> What is the difference between "class" and "object"?

Let us create a new class called [`Numeral`](../src/main/java/edu/emory/cs/algebraic/Numeral.java) that we want to be a super class of all numeral types defined later:

```java
package edu.emory.cs.algebraic;

public class Numeral {

}
```

* `package`: indicates the name of the package (in a hierarchy) that this class belongs to.
* [Access-level modifiers](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html): `public`, `protected`, _no modifier_, `private`.
> What are the acceptable access-level modifiers to declare a top-level class?

Let us declare two methods, `add()` and `multiply()`, that are two operations expected for all numeral types:

```java
public class Numeral {
    /**
     * Adds `n` to this numeral.
     * @param n the numeral to be added.
     */
    public void add(Numeral n) { /* cannot be implemented */ }

    /**
     * Multiplies `n` to this numeral.
     * @param n the numeral to be multiplied.
     */
    public void multiply(Numeral n) { /* cannot be implemented */ }
}
```

* `@param`: adds a [javadoc](https://docs.oracle.com/en/java/javase/14/docs/specs/javadoc/doc-comment-spec.html) comment about the parameter.

The problem is that we cannot define the methods unless we know what numeral type this class implements; in other words, it is too abstract to define those methods.
Thus, we need to declare `Numeral` as an abstract class type.
> What are the advantages of `Numeral` being an abstract class that becomes a super class of all numeral types?

There are two types of [abstract classes](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html) in Java, `abstract class` and `interface`.
> Can an object be instantiated by an abstract class or an interface?


----
## 2. Interface

Let us define `Numeral` as an interface:

```java
public interface Numeral {
    void add(Numeral n);
    void multiply(Numeral n);
}
```

* All methods in an interface have the access-level of `public` that does not need to be explicitly coded.
* Abstract methods in an interface are declared without their bodies.
> Who defines the bodies of these abstract methods?

Let us create a new interface called [`SignedNumeral`](../src/main/java/edu/emory/cs/algebraic/SignedNumeral.java) that inherits `Numeral` and adds two methods, `flipSing()` and `subtract()`:
> Can an interface inherit an abstract class or a regular class?

```java
public interface SignedNumeral extends Numeral {
    /** Flips the sign of this numeral. */
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
* `default`: allows an interface to define a [public method](https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html) with its body (introduced in Java 8).
> Can we call `add()` that is an abstract method without a body in the default method `subtract()`?

Although the logic of `subtract()` seems to be correct, `n.flipSign()` gives a compile error because `n` is a type of `Numeral` that does not include the method `flipSign()`, which is defined in `SignedNumeral` that is a subclass of `Numeral`.
> What kind of a compile error does `n.flipSign()` give?

There are three ways of handling this error:
* [Casting](#casting)
* [Polymorphism](#polymorphism)
* [Generics](#generics)


----
## 3. Casting

The first way is to downcast the type of `n` to `SignedNumeral`, which makes the compiler think that `n` has the method `flipSign()`:

```java
default void subtract(Numeral n) {
    ((SignedNumeral)n).flipSign();
    add(n);
    ((SignedNumeral)n).flipSign();
}
```

This removes the compile error; however, it will likely cause a worse kind of error called a [runtime error](https://docs.oracle.com/cd/E51711_01/DR/Runtime_Error_Messages.html).
> Why is a runtime error worse than a compile error?

[Downcasting](https://en.wikipedia.org/wiki/Downcasting), although allowed in Java, is generally not recommended unless there is no other way of accomplishing the job without using it.
> How can downcasting cause a runtime error in the above case?


----
## 4. Polymorphism

The second way is to change the type of `n` to `SignedNumeral` in the parameter setting:

```java
default void subtract(SignedNumeral n) {
    n.flipSign();
    add(n);
    n.flipSign();
}
```

This seems to solve the issue.
Then, what about `add()` and `multiply()` that are defined in `Numeral`?
Should we change their parameter types to `SignedNumeral` as well?

It is often the case that you do not have an access to change the code in a super class unless you are the author of it.
Even if you are the author, changing the code in a super class is not recommended.
> Why is it not recommended to change the code in a super class?

How about we override the `add()` method as follows?

```java
public interface SignedNumeral extends Numeral {
    @Override
    void add(SignedNumeral n);
    ...
}
```

* `@Override`: a predefined [annotation](https://docs.oracle.com/javase/tutorial/java/annotations/predefined.html) type to indicate the method is overridden.

The annotation, `@Override`, gives an error in this case because it is not considered an [overriding](https://docs.oracle.com/javase/tutorial/java/IandI/override.html).
> What are the criteria to override a method?

When the annotation is discarded, the error goes away and everything seems to be fine:

```java
public interface SignedNumeral extends Numeral {
    void add(SignedNumeral n);
    ...
}
```

However, this is considered an overloading, which defines two separate methods for `add()`, one taking `n` as `Numeral` and the other taking it as `SignedNumeral`.
Unfortunately, this would decrease the level of abstraction that we originally desired.
> What are good use cases of method overriding and overloading?


----
## 5. Generics

The third way is to use [generics](https://docs.oracle.com/javase/tutorial/java/generics/), introduced in Java 5:

```java
public interface Numeral<T extends Numeral<T>> {
    void add(T n);
    void multiply(T n);
}
```

* `T`: is a generic type that is a subtype of `Numeral`. A generic type can be recursively defined as `T` extends `Numeral<T>`.
* Once defined, `T` is considered a legitimate type in this interface such that it can be used to declare `add()` and `multiply()`.
> Can we define more than one generic type per class (or interface)?

The generic type `T` can be defined in a subclass of `Numeral` as follows:

```java
public interface SignedNumeral extends Numeral<SignedNumeral> {
    void flipSign();

    default void subtract(SignedNumeral n) {
        n.flipSign();
        add(n);
        n.flipSign();
    }
}
```

* `T` is defined as `SignedNumeral` as in `Numeral<SignedNumeral>`.

This would implicitly update the parameter types of `add()` and `multiply()`:

```java
void add(SignedNumeral n);
void multiply(SignedNumeral n);
```

The issue is that the implementations of those methods may require specific features defined in the subclass, which are not available in `SignedNumeral`.
Let us consider the following subclass inheriting `SignedNumeral`:

```java
public class LongInteger implements SignedNumeral {
    @Override
    public void flipSign() { /* to be implemented */ }

    @Override
    public void add(SignedNumeral n) { /* to be implemented */ }

    @Override
    public void multiply(SignedNumeral n) { /* to be implemented */ }
}
```

* `implements`: inherits multiple interfaces.
* `LongInteger` is a regular class so that all abstract methods declared in the super classes must be defined here.


Since the parameters of `add()` and `multiply()` are typed to `SignedNumeral`, `n` cannot call any method defined in `LongInteger`, which leads to the same issue addressed in [casting](#casting).
> Would the type of `n` being `SignedNumeral` an issue for `subtract()` as well?

Thus, `SignedNumeral` needs to define its own generic type and pass it onto `Numeral`:

```java
public interface SignedNumeral<T extends SignedNumeral<T>> extends Numeral<T> {
    void flipSign();

    default void subtract(T n) {
        n.flipSign();
        add(n);
        n.flipSign();
    }
}
```

* `T` is a generic type inheriting `SignedNumeral`, that implies all subclasses of `SignedNumeral`.
* `T` can be safely passed onto `Numeral` because if it is a subclass of `SignedNumeral`, it must be a subclass of `Numeral`, which is how `T` is defined in `Numeral` (see the first example in this section).

Generics are used everywhere in Java; it is important to understand the core concept of generics and be able to adapt in your codes.


----
## Enum



```java
public enum NumeralSign {
    POSITIVE,
    NEGATIVE;
}
```


----
## Abstract Class

It would be convenient to have a member instance that indicates the sign of the numeral:

```java


```



how many abstract methods are in this interface?

implements
multiple inheritance


<!-- Updated java_programming.md -->


> What are other types of methods allowed in an [interface](https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html)?<br>
> Can an interface have a member instance?



Comparable to Numeral

Collections

