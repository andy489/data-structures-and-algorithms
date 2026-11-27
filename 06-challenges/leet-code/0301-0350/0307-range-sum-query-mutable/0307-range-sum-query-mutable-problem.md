# 307. Range Sum Query - Mutable

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/range-sum-query-mutable/

---

## Problem Statement

Given an integer array `nums`, handle multiple queries of the following types:

1. **Update** the value of an element in `nums`.
2. Calculate the **sum** of the elements of `nums` between indices `left` and `right` **inclusive**.

Implement the `NumArray` class:
- `NumArray(int[] nums)` Initializes the object with the integer array `nums`.
- `void update(int index, int val)` Updates the value of `nums[index]` to be `val`.
- `int sumRange(int left, int right)` Returns the sum of the elements between indices `left` and `right` inclusive.

---

## Examples

**Example 1:**
```
Input:  ["NumArray","sumRange","update","sumRange"]
        [[[1,3,5]],[0,2],[1,2],[0,2]]
Output: [null,9,null,8]
```

---

## Constraints

- `1 <= nums.length <= 3 * 10^4`
- `-100 <= nums[i] <= 100`
- `0 <= index < nums.length`
- `-100 <= val <= 100`
- `0 <= left <= right < nums.length`
- At most `3 * 10^4` calls to `update` and `sumRange`.
