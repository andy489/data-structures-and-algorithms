# 310. Minimum Height Trees

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-height-trees/

---

## Problem Statement

A tree is an undirected graph in which any two vertices are connected by exactly one path.

Given a tree of `n` nodes labelled from `0` to `n - 1`, and an array of `n - 1` `edges` where `edges[i] = [ai, bi]`, you can choose any node as the root. When you select node `x` as the root, the result tree has height `h`. Those with minimum height are called **minimum height trees** (MHTs).

Return a list of all MHTs' root labels.

---

## Examples

**Example 1:**
```
Input:  n = 4, edges = [[1,0],[1,2],[1,3]]
Output: [1]
```

**Example 2:**
```
Input:  n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
Output: [3,4]
```

---

## Constraints

- `1 <= n <= 2 * 10^4`
- `edges.length == n - 1`
- `0 <= ai, bi < n`
- The input is guaranteed to be a tree.
