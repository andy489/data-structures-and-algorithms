# 1755. Closest Subsequence Sum

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/closest-subsequence-sum/

---

## Problem Statement

You are given an integer array `nums` and an integer `goal`.

You want to choose a subsequence of `nums` such that the sum of its elements is the closest possible to `goal`. That is, if the sum of the subsequence's elements is `sum`, then you want to **minimize** `|sum - goal|`.

Return the **minimum** possible value of `|sum - goal|`.

---

## Examples

**Example 1:**
```
Input: nums = [5,-7,3,5], goal = 6
Output: 0
Explanation: Choose the entire array as a subsequence, with sum 5 + (-7) + 3 + 5 = 6.
```

**Example 2:**
```
Input: nums = [7,-9,15,-2], goal = -5
Output: 1
Explanation: Choose the subsequence [7,-9,-2] with sum = -4, |(-4)-(-5)| = 1.
```

**Example 3:**
```
Input: nums = [1,2,3], goal = -7
Output: 7
```

---

## Constraints

- `1 <= nums.length <= 40`
- `-10^7 <= nums[i] <= 10^7`
- `-10^9 <= goal <= 10^9`
