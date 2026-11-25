# 1051. Height Checker

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/height-checker/

---

## Problem Statement

A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in **non-decreasing order** by height. Let this ordering be represented by the integer array `expected` where `expected[i]` is the expected height of the `i`th student in line.

You are given an integer array `heights` representing the **current order** that the students are standing in. Each `heights[i]` is the height of the `i`th student in line.

Return the number of indices where `heights[i] != expected[i]`.

---

## Examples

**Example 1:**
```
Input:  heights = [1,1,4,2,1,3]
Output: 3
```

**Example 2:**
```
Input:  heights = [5,1,2,3,4]
Output: 5
```

---

## Constraints

- `1 <= heights.length <= 100`
- `1 <= heights[i] <= 100`
