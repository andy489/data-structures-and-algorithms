# 1263. Minimum Moves to Move a Box to Their Target Location

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-moves-to-move-a-box-to-their-target-location/

---

## Problem Statement

A storekeeper is a game in which the player pushes boxes around in a warehouse trying to get them to target locations.

The game is represented by an `m x n` grid of characters where each element is a wall, floor, a box, or a storekeeper.

Return the minimum number of pushes to move the box to the target. If there is no way to reach the target, return `-1`.

---

## Examples

**Example 1:**
```
Input:  grid = [["#","#","#","#","#","#"],["#","T","#","#","#","#"],["#",".",".","B",".","#"],["#",".","#","#",".","#"],["#",".",".",".",".","#"],["#","#","#","#","#","#"]]
Output: 3
```

---

## Constraints

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m <= 20`
- `1 <= n <= 20`
- `grid contains only characters '.', '#',  'B', 'T', and 'S'`
