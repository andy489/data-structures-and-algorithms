# 3910. Count Connected Subgraphs with Even Node Sum

**Difficulty:** Hard

**Link:** https://leetcode.com/problems/count-connected-subgraphs-with-even-node-sum/

## Problem

You are given an undirected graph with `n` nodes labeled from 0 to `n - 1`. Node `i` has a **value** of `nums[i]`, which is either 0 or 1. The edges of the graph are given by a 2D array `edges` where `edges[i] = [u_i, v_i]` represents an edge between node `u_i` and node `v_i`.

For a **non-empty subset** `s` of nodes in the graph, we consider the **induced subgraph** of `s` generated as follows:
- We keep only the nodes in `s`.
- We keep only the edges whose two endpoints are both in `s`.

Return an integer representing the number of **non-empty** subsets `s` of nodes in the graph such that:
- The **induced subgraph** of `s` is **connected**.
- The **sum** of node **values** in `s` is **even**.

## Examples

**Example 1:**
```
Input: nums = [1,0,1], edges = [[0,1],[1,2]]
Output: 2
```

**Example 2:**
```
Input: nums = [0,1], edges = [[0,1]]
Output: 2
```

## Constraints

- `1 <= n <= 20`
- `nums[i]` is either 0 or 1.
- `0 <= edges.length <= n*(n-1)/2`
- `edges[i].length == 2`
- `0 <= u_i, v_i <= n - 1`
- `u_i != v_i`
- No repeated edges.
