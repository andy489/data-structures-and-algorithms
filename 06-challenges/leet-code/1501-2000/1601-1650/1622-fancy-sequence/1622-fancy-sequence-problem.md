# 1622. Fancy Sequence

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/fancy-sequence/

---

## Problem Statement

Write an API that generates fancy sequences using the `append`, `addAll`, and `multAll` operations.

Implement the `Fancy` class:

- `Fancy()` Initializes the object with an empty sequence.
- `void append(int val)` Appends an integer `val` to the end of the sequence.
- `void addAll(int inc)` Increments all existing values in the sequence by an integer `inc`.
- `void multAll(int m)` Multiplies all existing values in the sequence by an integer `m`.
- `long getIndex(int idx)` Gets the current value at index `idx` (0-indexed) of the sequence **modulo** `10^9 + 7`. If the index is greater or equal than the length of the sequence, return `-1`.

---

## Examples

**Example 1:**
```
Input:
["Fancy", "append", "addAll", "append", "multAll", "getIndex", "addAll", "append", "multAll", "getIndex", "getIndex", "getIndex"]
[[], [2], [3], [7], [2], [0], [3], [10], [2], [0], [1], [2]]
Output:
[null, null, null, null, null, 10, null, null, null, 26, 34, 20]
```

---

## Constraints
- `1 <= val, inc, m <= 100`
- `0 <= idx <= 10^5`
- At most `10^5` calls total to `append`, `addAll`, `multAll`, and `getIndex`.
