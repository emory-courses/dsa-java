# Disjoint Set

A disjoint set allows sets to be joined efficiently.
In the following example, each key in `{0, 1, 2, 3, 4}` is initially in its own set.

```
0: {0}
1: {1}
2: {2}
3: {3}
4: {4}
```
The `inSameSet(1, 3)` method checks if the keys `1` and `3` are in the same set.

```java
inSameSet(1, 3) -> false
```

The `union(1, 3)` method joins the two sets including `1` and `3` as one.

```
0: {0}
1: {1, 3}
2: {2}
3: {1, 3}
4: {4}
```

If we check if the keys `1` and `3` are in the same set, it should return `true` although for the keys `1` and `4`, it should return `false`.

```java
inSameSet(1, 3) -> true
inSameSet(1, 4) -> false
```

The `union(3, 4)` method joins the two sets including `3` and `4` as one.

```
0: {0}
1: {1, 3, 4}
2: {2}
3: {1, 3, 4}
4: {1, 3, 4}
```

If we check if `1`, `3` and `4` are in the same set, it should return `true`.

```java
`inSameSet(1, 4)` -> true
`inSameSet(3, 4)` -> true
```

Complete the two methods, `union()` and `find()` in the disjoint set such that the worst-case complexities become `O(1)` for both methods, respectively.

```java
public class DisjointSet {
    private int[] s_root;

    public DisjointSet(int size) {
        s_root = new int[size];
        Arrays.fill(s_root, -1);
    }

    public int union(int id1, int id2) {
        // TODO: to be filled
    }

    public int find(int id) {
        // TODO: to be filled
    }

    public boolean inSameSet(int id1, int id2) {
        return find(id1) == find(id2);
    }
}
```


## References

* [Disjoint Set](https://en.wikipedia.org/wiki/Disjoint-set_data_structure).