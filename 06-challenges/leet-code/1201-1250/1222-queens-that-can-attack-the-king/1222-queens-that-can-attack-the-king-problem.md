# 1222. Queens That Can Attack the King

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/queens-that-can-attack-the-king/

---

## Problem Statement

On an **8x8** chessboard, there can be multiple Black Queens and one White King.

Given an array of integer coordinates `queens` that represents the positions of the Black Queens, and a pair of coordinates `king` that represent the position of the White King, return the coordinates of all the queens (in any order) that can directly attack the King.

---

## Examples

**Example 1:**
```
Input:  queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
Output: [[0,1],[1,0],[3,3]]
```

---

## Constraints

- `1 <= queens.length <= 63`
- `queens[i].length == 2`
- `king.length == 2`
- `All positions are distinct`
