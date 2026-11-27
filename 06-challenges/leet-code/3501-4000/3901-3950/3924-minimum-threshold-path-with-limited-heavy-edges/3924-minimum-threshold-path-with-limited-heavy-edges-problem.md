# 3924. Minimum Threshold Path With Limited Heavy Edges

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/minimum-threshold-path-with-limited-heavy-edges/

## Problem

There is an undirected weighted graph with `n` nodes labeled from 0 to `n - 1`.

The graph is represented by a 2D integer array `edges`, where each edge `edges[i] = [ui, vi, wi]` indicates an undirected edge between nodes `ui` and `vi` with weight `wi`.

You are also given integers `source`, `target`, and `k`.

A `threshold` value determines whether an edge is considered **light** or **heavy**:
- An edge is **light** if its weight is **less than or equal to** `threshold`.
- An edge is **heavy** if its weight is **greater than** `threshold`.

A path from `source` to `target` is **valid** if it contains **at most** `k` heavy edges.

Return the **minimum integer** `threshold` such that **at least** one **valid** path exists from `source` to `target`. If no such path exists, return -1.

## Examples

**Example 1:**

```
Input: n = 6, edges = [[0,1,5],[1,2,3],[3,4,4],[4,5,1],[1,4,2]], source = 0, target = 3, k = 1
Output: 4
```

**Example 2:**

```
Input: n = 6, edges = [[0,1,3],[1,2,4],[3,4,5],[4,5,6]], source = 0, target = 4, k = 1
Output: -1
Explanation: There is no path from node 0 to node 4.
```

**Example 3:**

```
Input: n = 4, edges = [[0,1,2],[1,2,2],[2,3,2],[3,0,2]], source = 0, target = 0, k = 0
Output: 0
Explanation: source equals target, no edges needed, minimum threshold is 0.
```

## Constraints

- `1 <= n <= 10^3`
- `0 <= edges.length <= 10^3`
- `edges[i] = [ui, vi, wi]`
- `0 <= ui, vi <= n - 1`
- `1 <= wi <= 10^9`
- `0 <= source, target <= n - 1`
- `0 <= k <= edges.length`
