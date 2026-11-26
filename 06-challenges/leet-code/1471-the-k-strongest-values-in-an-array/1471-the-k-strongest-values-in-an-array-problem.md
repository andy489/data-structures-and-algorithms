# 1471. The K Strongest Values In An Array

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/the-k-strongest-values-in-an-array/

---

## Problem Statement

Return k strongest values from arr. Strength of x is |x - median| (larger is stronger). Ties broken by larger value.

---

## Examples

**Example 1:**
```
Input:  arr=[1,2,3,4,5],k=2
Output: [5,1]
```

**Example 2:**
```
Input:  arr=[1,1,3,5,5],k=2
Output: [5,5]
```

**Example 3:**
```
Input:  arr=[6,7,11,7,6,8],k=5
Output: [11,8,6,6,7]
```

---

## Constraints

- `1 <= arr.length <= 10^5`
- `1 <= k <= arr.length`
- `1 <= arr[i] <= 10^5`
