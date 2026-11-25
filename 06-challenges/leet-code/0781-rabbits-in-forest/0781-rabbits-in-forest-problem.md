# 781. Rabbits in Forest

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/rabbits-in-forest/

---

## Problem Statement

There is a forest with an unknown number of rabbits. We asked n rabbits **"How many rabbits have the same color as you?"** and collected the answers in an integer array `answers` where `answers[i]` is the answer of the `i`-th rabbit.

Given the array `answers`, return the **minimum** number of rabbits that could be in the forest.

---

## Examples

**Example 1:**
```
Input:  answers = [1,1,2]
Output: 5
Explanation: Two rabbits answered "1". There could be a group of 2 same-color rabbits. One rabbit answered "2", so there must be 3 same-color rabbits.
```

**Example 2:**
```
Input:  answers = [10,10,10]
Output: 11
```

---

## Constraints

- `1 <= answers.length <= 1000`
- `0 <= answers[i] < 1000`
