# 803. Bricks Falling When Hit

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/bricks-falling-when-hit/

---

## Problem Statement

You are given an `m x n` binary grid, where each `1` represents a brick and `0` represents an empty space. A brick is **stable** if:

- It is directly connected to the top of the grid, or
- At least one other brick in its four adjacent cells is stable.

You are also given an array `hits`, where each `hits[i] = [rowi, coli]` represents a brick to be erased. After each erase, additional bricks may fall.

Return an array `result`, where `result[i]` is the number of bricks that fall after the `i`th erasure.

---

## Examples

**Example 1:**
```
Input:  grid = [[1,0,0,0],[1,1,1,0]], hits = [[1,0]]
Output: [2]
```

**Example 2:**
```
Input:  grid = [[1,0,0,0],[1,1,0,0]], hits = [[1,1],[1,0]]
Output: [0,0]
```

---

## Constraints

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 200`
- `1 <= hits.length <= 4 * 10^4`
- `0 <= hits[i][0] < m`
- `0 <= hits[i][1] < n`
- All `hits[i]` are unique.
