# 1762. Buildings With an Ocean View

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/buildings-with-an-ocean-view/

---

## Problem Statement

There are `n` buildings in a line. You are given an integer array `heights` of size `n` that represents the heights of the buildings in the line.

The ocean is to the right of the buildings. A building has an **ocean view** if the building can see the ocean without obstructions. Formally, a building has an ocean view if all the buildings to its right have a **smaller** height.

Return *a list of indices (**0-indexed**) of buildings that have an ocean view, sorted in increasing order*.

---

## Examples

**Example 1:**
```
Input: heights = [4,2,3,1]
Output: [0,2,3]
Explanation: Building 1 (0-indexed) does not have an ocean view because building 2 is taller.
```

**Example 2:**
```
Input: heights = [4,3,2,1]
Output: [0,1,2,3]
Explanation: All the buildings have an ocean view.
```

**Example 3:**
```
Input: heights = [1,3,2,4]
Output: [3]
Explanation: Only building 3 has an ocean view.
```

---

## Constraints

- `1 <= heights.length <= 10^5`
- `1 <= heights[i] <= 10^8`
