# 2562. Find the Array Concatenation Value

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-the-array-concatenation-value/

---

## Problem Statement

You are given a **0-indexed** integer array `nums`.

The **concatenation** of two numbers is the number formed by concatenating their numerals.

- For example, the concatenation of `15`, `49` is `1549`.

The **concatenation value** of `nums` is initially equal to `0`. Perform this operation until `nums` becomes empty:

- If `nums` has a size greater than one, add the value of the concatenation of the first and the last element to the **concatenation value** of `nums`, and remove those two elements from `nums`.
- If only one element exists in `nums`, add its value to the **concatenation value** of `nums`, then remove it.

Return the concatenation value of `nums`.

---

## Examples

**Example 1:**
```
Input:  nums = [7,52,2,4]
Output: 596
```
*Explanation:* Concatenate 7 and 4 → 74 (sum = 74). Then 52 and 2 → 522 (sum = 596).

**Example 2:**
```
Input:  nums = [5,14,13,8,12]
Output: 673
```
*Explanation:* Concatenate 5 and 12 → 512 (sum = 512). Then 14 and 8 → 148 (sum = 660). Then 13 alone → 13 (sum = 673).

---

## Constraints

- `1 <= nums.length <= 1000`
- `1 <= nums[i] <= 10^4`
