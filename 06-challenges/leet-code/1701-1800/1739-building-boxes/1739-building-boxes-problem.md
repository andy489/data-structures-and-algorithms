# 1739. Building Boxes

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/building-boxes/

---

## Problem Statement

You have a cubic storeroom where the width, length, and height of the room are all equal to `n` units. You are asked to place `n` boxes in this room where each box is a unit cube placed on top of a surface. Each box may be placed on top of other boxes. A box can only be placed on top of a surface if **at most** three of its sides are unsupported (i.e., it must touch the wall, floor, or another box on each of its remaining sides).

Return *the **minimum** number of boxes touching the floor given that you can put at most `n` boxes in the room.*

---

## Examples

**Example 1:**
```
Input: n = 3
Output: 3
```

**Example 2:**
```
Input: n = 4
Output: 3
Explanation: The arrangement is a 2x2 pyramid with one box on top.
```

**Example 3:**
```
Input: n = 10
Output: 6
```

---

## Constraints

- `1 <= n <= 10^9`
