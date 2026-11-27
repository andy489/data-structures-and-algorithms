# 3372. Maximize the Number of Target Nodes After Connecting Trees I

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/

---

## Problem Statement

There exist two **undirected** trees with `n` and `m` nodes, with **distinct** labels in ranges `[0, n - 1]` and `[0, m - 1]`, respectively.

You are given two 2D integer arrays `edges1` and `edges2` of lengths `n - 1` and `m - 1`, respectively, where `edges1[i] = [ai, bi]` indicates an edge in the first tree and `edges2[i] = [ui, vi]` indicates an edge in the second tree. You are also given an integer `k`.

Node `u` is **target** to node `v` if the number of edges on the path from `u` to `v` is less than or equal to `k`. A node is always target to itself.

Return an array of `n` integers `answer`, where `answer[i]` is the **maximum** possible number of nodes **target** to node `i` of the first tree if you connect one node from the first tree to any node in the second tree.

Queries are independent — the added edge is removed before the next query.

---

## Examples

**Example 1:**
```
Input:  edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]], k = 2
Output: [9,7,9,8,8]
```

**Example 2:**
```
Input:  edges1 = [[0,1],[0,2],[0,3],[0,4]], edges2 = [[0,1],[1,2],[2,3]], k = 1
Output: [6,3,3,3,3]
```

---

## Constraints

- `2 <= n, m <= 1000`
- `edges1.length == n - 1`, `edges2.length == m - 1`
- `edges1[i].length == edges2[i].length == 2`
- `0 <= ai, bi < n`, `0 <= ui, vi < m`
- Both edge arrays represent valid trees
- `0 <= k <= 1000`
