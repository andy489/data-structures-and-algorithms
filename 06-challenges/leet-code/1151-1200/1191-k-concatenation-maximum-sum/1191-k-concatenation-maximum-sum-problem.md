# 1191. K-Concatenation Maximum Sum

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/k-concatenation-maximum-sum/

---

## Problem Statement

Given an integer array `arr` and an integer `k`, modify the array by repeating it `k` times.

For example, if `arr = [1, 2]` and `k = 3` then the modified array will be `[1, 2, 1, 2, 1, 2]`.

Return the maximum sub-array sum in the modified array. Note that the length of the sub-array can be `0` and its sum in that case is `0`.

As the answer can be very large, return the answer **modulo** `10^9 + 7`.

---

## Examples

**Example 1:**
```
Input:  arr = [1, 2], k = 3
Output: 9
Explanation: The concatenated array is [1, 2, 1, 2, 1, 2]. The maximum-sum subarray is the entire array, with sum 9.
```

**Example 2:**
```
Input:  arr = [1, -2, 1], k = 5
Output: 2
Explanation: Maximum subarray is [1, 1] spanning two copies, sum = 2.
```

**Example 3:**
```
Input:  arr = [-1, -2], k = 7
Output: 0
Explanation: Every element is negative; maximum possible sum is 0.
```

---

## Constraints

- `1 <= arr.length <= 10^5`
- `1 <= k <= 10^5`
- `-10^4 <= arr[i] <= 10^4`
