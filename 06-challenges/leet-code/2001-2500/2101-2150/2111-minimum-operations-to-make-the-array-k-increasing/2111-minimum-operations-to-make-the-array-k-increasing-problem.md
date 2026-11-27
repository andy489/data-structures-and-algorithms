# 2111. Minimum Operations to Make the Array K-Increasing

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/minimum-operations-to-make-the-array-k-increasing/

---

## Problem Statement

You are given a 0-indexed array `arr` consisting of `n` positive integers, and a positive integer `k`.

The array `arr` is called **K-increasing** if `arr[i-k] <= arr[i]` holds for every index `i`, where `k <= i <= n-1`.

In one operation, you can choose an index `i` and change `arr[i]` into any positive integer.

Return the **minimum number of operations** required to make the array K-increasing for the given `k`.

---

## Examples

**Example 1:**
```
Input:  arr = [5,4,3,2,1], k = 1
Output: 4
Explanation: For k=1, the array must be non-decreasing. E.g. [1,1,1,1,1] needs 4 ops.
```

**Example 2:**
```
Input:  arr = [4,1,5,2,6,2], k = 2
Output: 0
Explanation: Already K-increasing for k=2.
```

**Example 3:**
```
Input:  arr = [4,1,5,2,6,2], k = 3
Output: 2
Explanation: Indices 3 and 5 must be changed.
```

---

## Constraints

- `1 <= arr.length <= 10^5`
- `1 <= arr[i], k <= arr.length`
