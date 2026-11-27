# 3396. Minimum Number of Operations to Make Elements in Array Distinct

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/

---

## Problem Statement

You are given an integer array `nums`. You need to ensure that the elements in the array are **distinct**. To achieve this, you can perform the following operation any number of times:

- Remove **3 elements** from the **beginning** of the array. If the array has fewer than 3 elements, remove all remaining elements.

Return the **minimum number of operations** needed to make the remaining elements distinct.

Note that an empty array is considered to have distinct elements.

---

## Examples

**Example 1:**
```
Input:  nums = [1,2,3,4,2,3,3,5,7]
Output: 2
```
Explanation: After 2 operations (removing first 6 elements), the remaining array is `[3,5,7]` which is distinct.

**Example 2:**
```
Input:  nums = [4,5,6,4,4]
Output: 2
```
Explanation: After 2 operations, the array is empty (distinct).

**Example 3:**
```
Input:  nums = [6,7,8,9]
Output: 0
```
Explanation: The array is already distinct.

---

## Constraints

- `1 <= nums.length <= 100`
- `1 <= nums[i] <= 100`
