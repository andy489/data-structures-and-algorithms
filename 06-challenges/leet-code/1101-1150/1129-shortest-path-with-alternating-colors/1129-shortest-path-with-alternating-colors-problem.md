# 1129. Shortest Path with Alternating Colors

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/shortest-path-with-alternating-colors/

---

## Problem Statement

You are given an integer `n`, the number of nodes in a directed graph where the nodes are labeled from `0` to `n - 1`. Each edge is red or blue in this graph, and there could be self-edges and parallel edges.

You are given two arrays `redEdges` and `blueEdges` where:
- `redEdges[i] = [ai, bi]` indicates that there is a directed red edge from node `ai` to node `bi`.
- `blueEdges[j] = [uj, vj]` indicates that there is a directed blue edge from node `uj` to node `vj`.

Return an array `answer` of length `n`, where each `answer[x]` is the length of the shortest path from node `0` to node `x` such that the edge colors alternate along the path, or `-1` if such a path does not exist.

---

## Examples

**Example 1:**
```
Input:  n = 3, redEdges = [[0,1],[1,2]], blueEdges = []
Output: [0,1,-1]
```

**Example 2:**
```
Input:  n = 3, redEdges = [[0,1]], blueEdges = [[2,1]]
Output: [0,1,-1]
```

---

## Constraints

- `1 <= n <= 100`
- `0 <= redEdges.length, blueEdges.length <= 400`
- `redEdges[i].length == blueEdges[j].length == 2`
- `0 <= ai, bi, uj, vj < n`
