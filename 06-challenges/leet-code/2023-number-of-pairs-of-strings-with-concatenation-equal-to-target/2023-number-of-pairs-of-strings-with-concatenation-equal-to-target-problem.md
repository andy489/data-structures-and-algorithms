# 2023. Number of Pairs of Strings With Concatenation Equal to Target

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/

---

## Problem Statement

Given an array of digit strings `nums` and a digit string `target`, return the number of pairs of indices `(i, j)` (i != j) such that `nums[i] + nums[j] == target`.

---

## Examples

**Example 1:**
```
Input:  nums = ["777","7","77","77"], target = "7777"
Output: 4
```
Explanation: Pairs (0,1),(0,2),(1,2),(2,0) etc.

**Example 2:**
```
Input:  nums = ["123","4","12","34"], target = "1234"
Output: 2
```

---

## Constraints

- `2 <= nums.length <= 100`
- `1 <= nums[i].length <= 100`
- `2 <= target.length <= 100`
- `nums[i] and target consist of digits.`
