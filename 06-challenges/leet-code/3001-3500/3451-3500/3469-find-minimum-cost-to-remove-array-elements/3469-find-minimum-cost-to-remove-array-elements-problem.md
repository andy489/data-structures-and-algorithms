# 3469. Find Minimum Cost to Remove Array Elements

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-minimum-cost-to-remove-array-elements/

---

## Problem Statement

You are given an integer array `nums`. Your task is to remove **all elements** from the array by performing one of the following operations at each step until `nums` is empty:

- Choose any two elements from the first three elements of `nums` and remove them. The cost of this operation is the **maximum** of the two elements removed.
- If fewer than three elements remain in `nums`, remove all the remaining elements in a single operation. The cost of this operation is the **maximum** of the remaining elements.

Return the **minimum** cost required to remove all the elements.

---

## Examples

**Example 1:**
```
Input: nums = [6,2,8,4]
Output: 12
```

**Example 2:**
```
Input: nums = [2,1,3,3]
Output: 5
```

---

## Constraints

- `1 <= nums.length <= 1000`
- `1 <= nums[i] <= 10^6`
