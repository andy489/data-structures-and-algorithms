# 882. Reachable Nodes in Subdivided Graph

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/reachable-nodes-in-subdivided-graph/

---

## Problem Statement

You are given an undirected graph (the "original graph") with `n` nodes labeled from `0` to `n - 1`. You decide to subdivide each edge in this graph into a chain of nodes, with the number of new nodes varying between each edge.

The graph is given as a 2D array of `edges` where `edges[i] = [ui, vi, cnti]` and `cnti` is the total number of new nodes on the edge between `ui` and `vi`. Note that `cnti == 0` means no new nodes on the edge.

To reachable nodes starting from node `0` with at most `maxMoves` moves, return the number of nodes you can reach.

---

## Examples

**Example 1:**
```
Input:  edges = [[0,1,10],[0,2,1],[1,2,2]], maxMoves = 6, n = 3
Output: 13
```

---

## Constraints

- `0 <= edges.length <= min(n * (n - 1) / 2, 10^4)`
- `edges[i].length == 3`
- `0 <= ui < vi < n`
- `1 <= cnti <= 10^4`
- `0 <= maxMoves <= 10^9`
- `1 <= n <= 3000`
