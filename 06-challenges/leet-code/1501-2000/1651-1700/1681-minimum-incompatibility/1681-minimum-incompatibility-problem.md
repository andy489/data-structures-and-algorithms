# 1681. Minimum Incompatibility

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-incompatibility/

---

## Problem Statement

You are given an integer array `nums` and an integer `k`. You are asked to distribute all the integers in `nums` into `k` **subsets** of **equal size** such that the incompatibility of the distribution is **minimized**.

The **incompatibility** of a subset is the difference between the **maximum** and **minimum** values in that subset.

Return the **minimum possible incompatibility** sum over all `k` subsets after distributing the integers optimally, or return `-1` if it is not possible.

A subset is a group integers that appear **at least once** in the given array. Any two subsets must not have the same integers.

---

## Examples

**Example 1:**
```
Input: nums = [1,2,1,4], k = 2
Output: 4
Explanation: The optimal distribution of subsets is [1,2] and [1,4].
The incompatibility is (2-1) + (4-1) = 4.
Note that [1,1] and [2,4] would result in a smaller sum, but the two subsets must not have the same integer.
```

**Example 2:**
```
Input: nums = [6,3,8,1,3,1,2,2], k = 4
Output: 6
Explanation: The optimal distribution of subsets is [1,2],[2,3],[6,8],[1,3].
The incompatibility is (2-1) + (3-2) + (8-6) + (3-1) = 6.
```

**Example 3:**
```
Input: nums = [5,3,3,6,3,3], k = 3
Output: -1
Explanation: It is impossible to distribute nums into 3 subsets where no two subsets share the same integer (too many 3's).
```

---

## Constraints

- `1 <= k <= nums.length <= 16`
- `1 <= nums[i] <= nums.length`
- `nums.length` is divisible by `k`.
