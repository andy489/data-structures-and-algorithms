# 1267. Count Servers that Communicate

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-servers-that-communicate/

---

## Problem Statement

You are given a map of a server center, represented as a `m * n` integer matrix `grid`, where `1` means that on that cell there is a server and `0` means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.

Return the number of servers that communicate with at least one other server.

---

## Examples

**Example 1:**
```
Input:  grid = [[1,0],[0,1]]
Output: 0
```

---

## Constraints

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m <= 250`
- `1 <= n <= 250`
- `grid[i][j] == 0 or 1`
