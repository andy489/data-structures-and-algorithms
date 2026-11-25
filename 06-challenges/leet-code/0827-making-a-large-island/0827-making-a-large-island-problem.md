# 827. Making A Large Island

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/making-a-large-island/

---

## Problem Statement

You are given an `n x n` binary matrix `grid`. You are allowed to change at most one `0` to be `1`. Return the size of the largest island in `grid` after applying this operation.

An island is a 4-directionally connected group of `1`s.

---

## Examples

**Example 1:**
```
Input:  grid = [[1,0],[0,1]]
Output: 3
```

**Example 2:**
```
Input:  grid = [[1,1],[1,0]]
Output: 4
```

---

## Constraints

- `n == grid.length == grid[i].length`
- `1 <= n <= 500`
- `grid[i][j]` is either `0` or `1`.
