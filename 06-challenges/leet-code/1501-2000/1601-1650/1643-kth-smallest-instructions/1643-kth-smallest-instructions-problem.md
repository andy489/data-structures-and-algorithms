# 1643. Kth Smallest Instructions

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/kth-smallest-instructions/

---

## Problem Statement

Bob is standing at cell `(0, 0)`, and he wants to reach cell `destination = (row, column)`. He can only travel **right** and **down**. You are going to help Bob by providing **instructions** for his journey.

The instructions are represented as a string where each character is either:
- `'H'` (move right), or
- `'V'` (move down).

Multiple instructions can lead him to his destination. Given `destination` and an integer `k`, return the `k`-th **lexicographically smallest** instructions that will take Bob to his destination.

---

## Examples

**Example 1:**
```
Input: destination = [2,3], k = 1
Output: "HHHVV"
```

**Example 2:**
```
Input: destination = [2,3], k = 2
Output: "HHVHV"
```

**Example 3:**
```
Input: destination = [2,3], k = 3
Output: "HHVVH"
```

---

## Constraints

- `destination.length == 2`
- `1 <= row, column <= 15`
- `1 <= k <= nCr(row + column, row)`
