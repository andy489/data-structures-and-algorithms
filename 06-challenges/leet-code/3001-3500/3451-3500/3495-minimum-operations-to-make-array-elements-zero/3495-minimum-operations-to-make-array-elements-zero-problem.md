# 3495. Minimum Operations to Make Array Elements Zero

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-operations-to-make-array-elements-zero/

---

## Problem Statement

You are given a 2D array `queries`, where `queries[i]` is of the form `[l, r]`. Each `queries[i]` defines an array of integers `nums` consisting of elements ranging from `l` to `r`, both **inclusive**.

In one operation, you can:

- Select two integers `a` and `b` from the array.
- Replace them with `floor(a / 4)` and `floor(b / 4)`.

Your task is to determine the **minimum** number of operations required to reduce all elements of the array to zero for each query. Return the sum of the results for all queries.

---

## Examples

**Example 1:**
```
Input: queries = [[1,2],[2,4]]
Output: 3
```

**Example 2:**
```
Input: queries = [[2,6]]
Output: 4
```

---

## Constraints

- `1 <= queries.length <= 10^5`
- `queries[i].length == 2`
- `queries[i] == [l, r]`
- `1 <= l < r <= 10^9`
