# 1782. Count Pairs of Nodes

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-pairs-of-nodes/

---

## Problem Statement

You are given an undirected graph defined by an integer `n`, the number of nodes, and a 2D integer array `edges` where `edges[i] = [u_i, v_i]` indicates that there is an undirected edge between nodes `u_i` and `v_i`. Note that the graph may contain **multi-edges**.

You are also given a 0-indexed integer array `queries`.

Let `incident(a, b)` be defined as the **number of edges** that are incident to **either** `a` or `b`.

The answer to the `j^th` query is the number of pairs of nodes `(a, b)` that satisfy **both** of the following conditions:

- `a < b`
- `incident(a, b) > queries[j]`

Return an array `answers` such that `answers[j]` is the answer of the `j^th` query.

Note: There can be **multiple** edges between two nodes.

---

## Examples

**Example 1:**
```
Input: n = 4, edges = [[1,2],[2,4],[1,3],[2,3],[2,1]], queries = [2,3]
Output: [6,5]
```

**Example 2:**
```
Input: n = 5, edges = [[1,2],[1,3],[2,3],[2,4],[2,5],[3,5],[4,5]], queries = [1,2,3,4,5]
Output: [10,10,9,8,6]
```

---

## Constraints

- `2 <= n <= 2 * 10^4`
- `1 <= edges.length <= 10^5`
- `1 <= u_i, v_i <= n`
- `u_i != v_i`
- `1 <= queries.length <= 20`
- `0 <= queries[j] < edges.length`
