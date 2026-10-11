# 11. Container With Most Water

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/container-with-most-water/

---

## Problem Statement

You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `i`th line are `(i, 0)` and `(i, height[i])`.

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the **maximum amount of water a container can store**.

**Notice** that you may not slant the container.

---

## Examples

**Example 1:**
```
Input:  height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The lines at index 1 (height 8) and index 8 (height 7) form
             a container of width 7 and min-height 7, giving area 49.
```

**Example 2:**
```
Input:  height = [1,1]
Output: 1
```

---

## Constraints

- `n == height.length`
- `2 <= n <= 10^5`
- `0 <= height[i] <= 10^4`
