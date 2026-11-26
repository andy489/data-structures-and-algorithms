# 2001. Number of Pairs of Interchangeable Rectangles

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/

---

## Problem Statement

You are given `n` rectangles represented by a 0-indexed 2D integer array `rectangles`, where `rectangles[i] = [widthi, heighti]`. Two rectangles `i` and `j` (i < j) are considered **interchangeable** if they have the **same** width-to-height ratio. Return the **number of pairs** of interchangeable rectangles.

---

## Examples

**Example 1:**
```
Input:  rectangles = [[4,8],[3,6],[10,20],[15,30]]
Output: 6
```
Explanation: All 4 rectangles have ratio 1:2, so C(4,2)=6 pairs.

**Example 2:**
```
Input:  rectangles = [[4,5],[7,8]]
Output: 0
```
Explanation: No two rectangles share the same ratio.

---

## Constraints

- `n == rectangles.length`
- `1 <= n <= 10^5`
- `rectangles[i].length == 2`
- `1 <= widthi, heighti <= 10^5`
