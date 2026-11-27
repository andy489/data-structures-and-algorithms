# 1685. Sum of Absolute Differences in a Sorted Array

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/

---

## Problem Statement

You are given an integer array `nums` sorted in **non-decreasing** order.

Build and return an integer array `result` with the same length as `nums` such that `result[i]` is equal to the **summation of absolute differences** between `nums[i]` and all the other elements in the array.

In other words, `result[i] = sum(|nums[i]-nums[j]|)` where `0 <= j < nums.length` and `j != i`.

---

## Examples

**Example 1:**
```
Input: nums = [2,3,5]
Output: [4,3,5]
Explanation: Assuming 0-indexed.
result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4
result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3
result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5
```

**Example 2:**
```
Input: nums = [1,4,6,8,10]
Output: [24,15,13,15,21]
```

---

## Constraints

- `2 <= nums.length <= 10^5`
- `1 <= nums[i] <= nums[i + 1] <= 10^4`
