# 174. Dungeon Game

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/dungeon-game/

---

## Problem Statement

The demons had captured the princess and imprisoned her in the **bottom-right** room of a `dungeon`. The dungeon consists of `m x n` rooms laid out in a 2D grid. Valiant knights were dispatched to rescue the princess.

The knight starts in the **top-left** room and must fight their way through the dungeon. Each room has a value (negative = damage, positive = magic orbs that increase health). The knight dies if their health drops to 0 or below at any point.

Given the `m x n` integer grid `dungeon`, return the knight's minimum initial health so that they can rescue the princess.

**Note:** The knight can only move either right or down.

---

## Examples

**Example 1:**
```
Input:
dungeon = [[-2,-3,3],
           [-5,-10,1],
           [10,30,-5]]
Output: 7
```

**Example 2:**
```
Input:  dungeon = [[0]]
Output: 1
```

---

## Constraints

- `m == dungeon.length`
- `n == dungeon[i].length`
- `1 <= m, n <= 200`
- `-1000 <= dungeon[i][j] <= 1000`
