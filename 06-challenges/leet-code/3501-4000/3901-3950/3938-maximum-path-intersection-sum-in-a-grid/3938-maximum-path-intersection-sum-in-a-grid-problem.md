# 3938. Maximum Path Intersection Sum in a Grid

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-path-intersection-sum-in-a-grid/

## Problem

You are given an `m x n` integer matrix `grid`.

Two players move across the grid:

- Player 1 starts at the top-left cell `(0, 0)` and can move only right or down. Their destination is the bottom-right cell `(m - 1, n - 1)`.
- Player 2 starts at the bottom-left cell `(m - 1, 0)` and can move only right or up. Their destination is the top-right cell `(0, n - 1)`.

Each player must choose a valid path from their respective starting cell to their destination.

A cell is called **shared** if it belongs to **both** chosen paths.

Return an integer denoting the **maximum** possible sum of values of all **shared** cells.

## Examples

**Example 1:**
```
Input: grid = [[1,2,0,-3],[1,-2,1,0],[-4,2,-1,3],[3,-3,3,-2],[-1,-5,0,1]]
Output: 4
Explanation:
- Player 1 follows the path: (0,0) -> (1,0) -> (2,0) -> (2,1) -> (2,2) -> (2,3) -> (3,3) -> (4,3)
- Player 2 follows the path: (4,0) -> (4,1) -> (3,1) -> (2,1) -> (2,2) -> (2,3) -> (1,3) -> (0,3)
- The shared cells are (2,1), (2,2), and (2,3).
- The sum is 2 + (-1) + 3 = 4.
```

**Example 2:**
```
Input: grid = [[4,-2,-3],[-1,-3,-1],[-4,2,-1]]
Output: 3
Explanation:
- Player 1 follows: (0,0) -> (1,0) -> (1,1) -> (1,2) -> (2,2)
- Player 2 follows: (2,0) -> (1,0) -> (0,0) -> (0,1) -> (0,2)
- The shared cells are (0,0) and (1,0).
- The sum is 4 + (-1) = 3.
```

## Constraints

- `m == grid.length`
- `n == grid[i].length`
- `2 <= m, n <= 1000`
- `4 <= m * n <= 5 * 10^5`
- `-100 <= grid[i][j] <= 100`
