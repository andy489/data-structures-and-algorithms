# 3311. Construct 2D Grid Matching Graph Layout

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/construct-2d-grid-matching-graph-layout/

## Problem

You are given a 2D integer array `edges` representing an **undirected** graph having `n` nodes, where `edges[i] = [u_i, v_i]` denotes an edge between nodes `u_i` and `v_i`.

Construct a 2D grid that satisfies these conditions:
- The grid contains **all nodes** from `0` to `n - 1` in its cells, with each node appearing exactly **once**.
- Two nodes should be in adjacent grid cells (horizontally or vertically) **if and only if** there is an edge between them.

It is guaranteed that `edges` can form a 2D grid that satisfies the conditions.

Return a 2D integer array satisfying the conditions above. If there are multiple solutions, return any of them.

## Examples

**Example 1:**
```
Input: n = 4, edges = [[0,1],[0,2],[1,3],[2,3]]
Output: [[3,1],[2,0]]
```

**Example 2:**
```
Input: n = 5, edges = [[0,1],[1,3],[2,3],[2,4]]
Output: [[4,2,3,1,0]]
```

**Example 3:**
```
Input: n = 9, edges = [[0,1],[0,4],[0,5],[1,7],[2,3],[2,4],[2,5],[3,6],[4,6],[4,7],[6,8],[7,8]]
Output: [[8,6,3],[7,4,2],[1,0,5]]
```

## Constraints

- `2 <= n <= 5 * 10^4`
- `1 <= edges.length <= 10^5`
- `0 <= u_i < v_i < n`
- All the edges are distinct.
- The input is guaranteed to form a valid 2D grid.
