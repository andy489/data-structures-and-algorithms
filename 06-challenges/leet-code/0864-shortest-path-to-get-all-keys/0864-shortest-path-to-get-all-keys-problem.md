# 864. Shortest Path to Get All Keys

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/shortest-path-to-get-all-keys/

---

## Problem Statement

You are given an `m x n` grid where:
- `'.'` is an empty cell
- `'#'` is a wall
- `'@'` is the starting point
- Lowercase letters represent keys
- Uppercase letters represent locks

Return the lowest number of moves to acquire all keys. If it is impossible, return `-1`.

---

## Examples

**Example 1:**
```
Input:  grid = ["@.a..","###.#","b.A.B"]
Output: 8
```

**Example 2:**
```
Input:  grid = ["@..aA","..B#.","....b"]
Output: 6
```

---

## Constraints

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 30`
- `grid[i][j]` is either an English letter, `'.'`, `'#'`, or `'@'`.
- There is exactly one `'@'` in the grid.
- The number of keys in the grid is in the range `[1, 6]`.
- Each key in the grid has a matching lock.
