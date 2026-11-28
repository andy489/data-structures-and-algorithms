# 3452. Sum of Good Numbers

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/sum-of-good-numbers/

---

## Problem Statement

Given an array of integers `nums` and an integer `k`, an element `nums[i]` is considered **good** if it is **strictly** greater than the elements at indices `i - k` and `i + k` (if those indices exist). If neither of these indices exists, `nums[i]` is still considered **good**.

Return the **sum** of all the **good** elements in the array.

---

## Examples

**Example 1:**
```
Input: nums = [1,3,2,1,5,4], k = 2
Output: 12
```

**Example 2:**
```
Input: nums = [2,1], k = 1
Output: 2
```

---

## Constraints

- `2 <= nums.length <= 100`
- `1 <= nums[i] <= 1000`
- `1 <= k <= floor(nums.length / 2)`
