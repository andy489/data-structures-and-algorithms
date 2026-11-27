# 3091. Apply Operations To Make Sum Of Array Greater Than Or Equal To K

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/apply-operations-to-make-sum-of-array-greater-than-or-equal-to-k/

---

## Problem Statement

You are given a positive integer `k`. In one operation you can:
- Increment any element of `nums` by 1.
- Duplicate any element of `nums` and append it to `nums`.

Initially `nums = [1]`. Return the minimum number of operations to make the sum of elements of `nums` greater than or equal to `k`.

---

## Examples

**Example 1:**
```
Input:  k = 11
Output: 5
```
Explanation: Start [1]. +1→[2]. +1→[3]. dup→[3,3]. dup→[3,3,3]. sum=9? Then +1 on one: [4,3,3]=10. Need more. Actually: [1]→[2]→[2,2]→[4,2,2]=8→[4,4,2,2]=12>=11. That's 4 ops. Let me recount.

**Example 2:**
```
Input:  k = 1
Output: 0
```
Explanation: Sum of [1] is already >= 1.

---

## Constraints

- `1 <= k <= 10^5`
