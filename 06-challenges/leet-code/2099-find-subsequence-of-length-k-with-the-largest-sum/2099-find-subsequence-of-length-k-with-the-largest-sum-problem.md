# 2099. Find Subsequence of Length K With the Largest Sum

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/

---

## Problem Statement

You are given an integer array `nums` and an integer `k`. Find a **subsequence** of `nums` of length `k` that has the **largest** sum. A subsequence maintains the original order. Return any such subsequence as an integer array of length `k`.

---

## Examples

**Example 1:**
```
Input:  nums = [2,1,3,3], k = 2
Output: [3,3]
```
Explanation: Pick the two largest.

**Example 2:**
```
Input:  nums = [-1,-2,3,4], k = 3
Output: [-1,3,4]
```
Explanation: Pick three largest by value.

**Example 3:**
```
Input:  nums = [3,4,3,3], k = 2
Output: [3,4]
```

---

## Constraints

- `1 <= nums.length <= 1000`
- `1 <= k <= nums.length`
- `-10^5 <= nums[i] <= 10^5`
