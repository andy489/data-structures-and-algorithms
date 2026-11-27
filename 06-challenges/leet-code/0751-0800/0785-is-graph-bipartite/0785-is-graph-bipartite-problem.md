# 785. Is Graph Bipartite?

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/is-graph-bipartite/

---

## Problem Statement

There is an undirected graph with `n` nodes, where each node is numbered between `0` and `n - 1`. You are given a 2D array `graph`, where `graph[u]` is an array of nodes that node `u` is adjacent to. The graph does not contain self-loops, parallel edges, and it may not be connected.

A graph is **bipartite** if the nodes can be partitioned into two independent sets `A` and `B` such that every edge in the graph connects a node in set `A` and a node in set `B`.

Return `true` if and only if it is **bipartite**.

---

## Examples

**Example 1:**
```
Input:  graph = [[1,2,3],[0,2],[1,3],[0,2]]
Output: false
```

**Example 2:**
```
Input:  graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
```

---

## Constraints

- `n == graph.length`
- `1 <= n <= 100`
- `0 <= graph[u].length < n`
- `0 <= graph[u][i] <= n - 1`
- `graph[u]` does not contain `u`.
- All the values of `graph[u]` are **unique**.
- If `graph[u]` contains `v`, then `graph[v]` contains `u`.
