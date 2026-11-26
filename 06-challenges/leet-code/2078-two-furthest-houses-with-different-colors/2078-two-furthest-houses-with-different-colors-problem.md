# 2078. Two Furthest Houses With Different Colors

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/two-furthest-houses-with-different-colors/

---

## Problem Statement

There are `n` houses on a street, each with a color. `colors[i]` is the color of the i-th house. Return the **maximum distance** between two houses with **different** colors.

---

## Examples

**Example 1:**
```
Input:  colors = [1,1,1,6,1,1,1]
Output: 3
```
Explanation: Houses 0 and 3 (or 3 and 6).

**Example 2:**
```
Input:  colors = [1,8,3,8,3]
Output: 4
```
Explanation: Houses 0 and 4.

**Example 3:**
```
Input:  colors = [0,1]
Output: 1
```

---

## Constraints

- `n == colors.length`
- `2 <= n <= 100`
- `0 <= colors[i] <= 100`
- `Test data are generated such that at least two houses have different colors.`
