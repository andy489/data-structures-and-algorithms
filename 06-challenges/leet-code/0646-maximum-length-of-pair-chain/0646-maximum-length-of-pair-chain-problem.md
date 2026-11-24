# 646. Maximum Length of Pair Chain

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-length-of-pair-chain/

---

## Problem Statement

You are given an array of `n` pairs `pairs` where `pairs[i] = [left_i, right_i]` and `left_i < right_i`.

A pair `p2 = [c, d]` **follows** a pair `p1 = [a, b]` if `b < c`. A **chain** of pairs can be formed in this fashion.

Return the length **longest chain** which can be formed.

You do not need to use up all the given intervals. You can select pairs in any order.

---

## Examples

**Example 1:**
```
Input:  pairs = [[1,2],[2,3],[3,4]]
Output: 2
```

**Example 2:**
```
Input:  pairs = [[1,2],[7,8],[4,5]]
Output: 3
```

---

## Constraints

- `n == pairs.length`
- `1 <= n <= 1000`
- `-1000 <= left_i < right_i <= 1000`
