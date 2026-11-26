# 526. Beautiful Arrangement

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/beautiful-arrangement/

---

## Problem Statement

Suppose you have `n` integers labeled `1` through `n`. A permutation of those `n` integers `perm` (**1-indexed**) is considered a **beautiful arrangement** if for every `i` (`1 <= i <= n`), **either** of the following is true:

- `perm[i]` is divisible by `i`.
- `i` is divisible by `perm[i]`.

Given an integer `n`, return the **number** of the **beautiful arrangements** that you can construct.

---

## Examples

**Example 1:**
```
Input:  n = 2
Output: 2
Explanation: [1,2] and [2,1] are both beautiful.
```

**Example 2:**
```
Input:  n = 1
Output: 1
```

---

## Constraints

- `1 <= n <= 15`
