# 1283. Find the Smallest Divisor Given a Threshold

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

---

## Problem Statement

Given an array of integers `nums` and an integer `threshold`, we will choose a positive integer `divisor`, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to `threshold`.

Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: `7/3 = 3` and `10/2 = 5`).

It is guaranteed that there will be an answer.

---

## Examples

**Example 1:**
```
Input:  nums = [1,2,5,9], threshold = 6
Output: 5
```

---

## Constraints

- `1 <= nums.length <= 5 * 10^4`
- `1 <= nums[i] <= 10^6`
- `nums.length <= threshold <= 10^6`
