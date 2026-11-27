# 1719. Number of Ways to Reconstruct a Tree

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-ways-to-reconstruct-a-tree/

---

## Problem Statement

You are given an array `pairs`, where `pairs[i] = [x_i, y_i]`, and:

- There are no duplicates.
- `x_i < y_i`

Let `ways` be the number of rooted trees that satisfy the following conditions:

- The tree consists of nodes whose values appeared in `pairs`.
- A pair `[x_i, y_i]` exists in `pairs` **if and only if** `x_i` is an ancestor of `y_i` or `y_i` is an ancestor of `x_i`.
- **Note:** the tree does not have to be a binary tree.

Two ways are considered to be different if there is at least one node that has different parents in both ways.

Return:
- `0` if `ways == 0`
- `1` if `ways == 1`
- `2` if `ways > 1`

---

## Examples

**Example 1:**
```
Input: pairs = [[1,2],[2,3]]
Output: 1
```

**Example 2:**
```
Input: pairs = [[1,2],[2,3],[1,3]]
Output: 2
```

**Example 3:**
```
Input: pairs = [[1,2],[2,3],[2,4],[1,5]]
Output: 0
```

---

## Constraints

- `1 <= pairs.length <= 10^5`
- `1 <= x_i < y_i <= 500`
- The elements in `pairs` are distinct.
