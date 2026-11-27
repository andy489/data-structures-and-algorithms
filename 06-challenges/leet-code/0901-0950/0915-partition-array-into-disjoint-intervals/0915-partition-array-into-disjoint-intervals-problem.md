# 915. Partition Array into Disjoint Intervals

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/partition-array-into-disjoint-intervals/

---

## Problem Statement

Given an integer array `nums`, partition it into two (contiguous) subarrays `left` and `right` so that:
- Every element in `left` is less than or equal to every element in `right`.
- `left` and `right` are non-empty.
- `left` has the smallest possible size.

Return the **length** of `left` after such a partitioning.

---

## Examples

**Example 1:**
```
Input:  nums = [5,0,3,8,6]
Output: 3
```

**Example 2:**
```
Input:  nums = [1,1,1,0,6,12]
Output: 4
```

---

## Constraints

- `2 <= nums.length <= 3 * 10^4`
- `0 <= nums[i] <= 10^6`
- It is guaranteed there is at least one valid answer.
