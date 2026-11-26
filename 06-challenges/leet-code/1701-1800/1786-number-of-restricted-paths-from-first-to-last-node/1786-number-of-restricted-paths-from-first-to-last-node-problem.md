# 1786. Number of Restricted Paths From First to Last Node

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-restricted-paths-from-first-to-last-node/

---

## Problem Statement

There is an undirected weighted connected graph. You are given a positive integer `n` which denotes that the graph has `n` nodes labeled from `1` to `n`, and an array `edges` where `edges[i] = [u_i, v_i, weight_i]` denotes that there is an edge between nodes `u_i` and `v_i` with weight equal to `weight_i`.

A path from node `start` to node `end` is a sequence of nodes `[z0, z1, z2, ..., zk]` where `z0 = start` and `zk = end` and there is an edge between `z_i` and `z_{i+1}` where `0 <= i <= k-1`.

The length of a path is the sum of the weights of the edges in the path.

The shortest path length between node `u` and node `n` is denoted as `distanceToLastNode(u)`.

A **restricted path** is a path that also satisfies `distanceToLastNode(z_i) > distanceToLastNode(z_{i+1})` for each `0 <= i <= k-1`.

Return the number of restricted paths from node `1` to node `n`. Since that number may be too large, return it **modulo** `10^9 + 7`.

---

## Examples

**Example 1:**
```
Input: n = 5, edges = [[1,2,3],[1,3,3],[2,3,1],[1,4,2],[5,2,2],[3,5,1],[5,4,10]]
Output: 3
```

**Example 2:**
```
Input: n = 7, edges = [[1,3,1],[4,1,2],[7,3,4],[2,5,3],[5,6,1],[6,7,2],[7,2,1],[3,2,10]]
Output: 1
```

---

## Constraints

- `1 <= n <= 2 * 10^4`
- `n - 1 <= edges.length <= 4 * 10^4`
- `edges[i].length == 3`
- `1 <= u_i, v_i <= n`
- `u_i != v_i`
- `1 <= weight_i <= 10^5`
- There is exactly one simple path between any two nodes.
