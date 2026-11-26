# 868. Binary Gap

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/binary-gap/

---

## Problem Statement

Given a positive integer `n`, find and return the longest distance between any two adjacent `1`'s in the binary representation of `n`. If there are no two adjacent `1`'s, return `0`.

Two `1`'s are adjacent if there are only `0`'s separating them.

---

## Examples

**Example 1:**
```
Input:  n = 22
Output: 2
Explanation: 22 in binary is "10110". Adjacent 1s at positions 1,2 (dist 1) and 1,3 (dist 2). Max is 2.
```

**Example 2:**
```
Input:  n = 8
Output: 0
```

---

## Constraints

- `1 <= n <= 10^9`
