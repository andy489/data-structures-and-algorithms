# 1200. Minimum Absolute Difference

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-absolute-difference/

---

## Problem Statement

Given an array of **distinct** integers `arr`, find all pairs of elements with the minimum absolute difference of any two elements.

Return a list of pairs in ascending order (with respect to pairs), each pair `[a, b]` follows:
- `a`, `b` are from `arr`
- `a < b`
- `b - a` equals the minimum absolute difference of any two elements in `arr`

---

## Examples

**Example 1:**
```
Input:  arr = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]
```

**Example 2:**
```
Input:  arr = [1,3,6,10,15]
Output: [[1,3]]
```

---

## Constraints

- `2 <= arr.length <= 10^5`
- `-10^6 <= arr[i] <= 10^6`
