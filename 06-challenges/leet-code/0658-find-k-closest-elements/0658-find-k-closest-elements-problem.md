# 658. Find K Closest Elements

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-k-closest-elements/

---

## Problem Statement

Given a **sorted** integer array `arr`, two integers `k` and `x`, return the `k` closest integers to `x` in the array. The result should also be sorted in ascending order.

An integer `a` is closer to `x` than an integer `b` if:
- `|a - x| < |b - x|`, or
- `|a - x| == |b - x|` and `a < b`

---

## Examples

**Example 1:**
```
Input:  arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
```

**Example 2:**
```
Input:  arr = [1,1,2,3,4,5,6,6,7], k = 3, x = -1
Output: [1,1,2]
```

---

## Constraints

- `1 <= k <= arr.length`
- `1 <= arr.length <= 10⁴`
- `arr` is sorted in **ascending** order.
- `-10⁴ <= arr[i], x <= 10⁴`
