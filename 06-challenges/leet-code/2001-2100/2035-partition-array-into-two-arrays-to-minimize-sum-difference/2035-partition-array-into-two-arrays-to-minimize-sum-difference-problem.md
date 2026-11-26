# 2035. Partition Array Into Two Arrays to Minimize Sum Difference

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/

---

## Problem Statement

You are given an integer array `nums` of `2n` integers. Partition `nums` into two arrays of length `n` each to minimize `|sum1 - sum2|`. Return the **minimum** absolute difference.

---

## Examples

**Example 1:**
```
Input:  nums = [3,9,7,3]
Output: 2
```
Explanation: Partition [3,3] and [9,7]: |6-16|=10. Better: [3,7] and [9,3]: |10-12|=2.

**Example 2:**
```
Input:  nums = [-36,36]
Output: 72
```

**Example 3:**
```
Input:  nums = [2,-1,0,4,-2,-9]
Output: 0
```

---

## Constraints

- `1 <= n <= 15`
- `nums.length == 2 * n`
- `-10^7 <= nums[i] <= 10^7`
