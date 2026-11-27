# 3887. Incremental Even-Weighted Cycle Queries

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/incremental-even-weighted-cycle-queries/

## Problem Statement

You are given a positive integer `n`.

There is an **undirected** graph with `n` nodes labeled from 0 to `n - 1`. Initially, the graph has no edges.

You are also given a 2D integer array `edges`, where `edges[i] = [u_i, v_i, w_i]` represents an edge between nodes `u_i` and `v_i` with weight `w_i`. The weight `w_i` is either 0 or 1.

Process the edges in `edges` in the given order. For each edge, add it to the graph only if, after adding it, the sum of the weights of the edges in **every** cycle in the resulting graph is **even**.

Return an integer denoting the number of edges that are successfully added to the graph.

## Examples

### Example 1
**Input:** `n = 3, edges = [[0,1,1],[1,2,1],[0,2,1]]`
**Output:** `2`

**Explanation:**
- `[0, 1, 1]`: Add edge between 0 and 1 with weight 1.
- `[1, 2, 1]`: Add edge between 1 and 2 with weight 1.
- `[0, 2, 1]`: Not added because the cycle 0-1-2-0 has total weight 1+1+1=3 (odd).

### Example 2
**Input:** `n = 3, edges = [[0,1,1],[1,2,1],[0,2,0]]`
**Output:** `3`

**Explanation:**
- `[0, 1, 1]`: Add edge between 0 and 1 with weight 1.
- `[1, 2, 1]`: Add edge between 1 and 2 with weight 1.
- `[0, 2, 0]`: Add edge between 0 and 2 with weight 0. The cycle 0-1-2-0 has total weight 1+1+0=2 (even).

## Constraints

- `3 <= n <= 5 * 10^4`
- `1 <= edges.length <= 5 * 10^4`
- `edges[i] = [u_i, v_i, w_i]`
- `0 <= u_i < v_i < n`
- All edges are distinct.
- `w_i = 0 or w_i = 1`
