# 1656. Design an Ordered Stream

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/design-an-ordered-stream/

---

## Problem Statement

There is a stream of `n` `(idKey, value)` pairs arriving in an **arbitrary** order, where `idKey` is an integer between `1` and `n` and `value` is a string. No two pairs have the same `idKey`.

Design a stream that returns the values in **increasing order of their IDs** by returning a **chunk** (list of consecutive values) for each insertion. Each chunk consists of the consecutive values starting from the **pointer** (initially set to `1`).

Implement the `OrderedStream` class:
- `OrderedStream(int n)` Constructs the stream to take `n` values.
- `List<String> insert(int idKey, String value)` Inserts the pair `(idKey, value)` into the stream, then returns the **largest possible chunk** of currently inserted values that appear next in the order.

---

## Examples

**Example 1:**
```
Input:
["OrderedStream", "insert", "insert", "insert", "insert", "insert"]
[[5], [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]]
Output:
[null, [], ["aaaaa"], ["bbbbb", "ccccc"], [], ["ddddd", "eeeee"]]
```

---

## Constraints

- `1 <= n <= 1000`
- `1 <= id <= n`
- `value.length == 5`
- `1 <= calls <= 1000`
- Each call to `insert` will have a unique `id`.
