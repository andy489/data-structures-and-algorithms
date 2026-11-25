# 834. Sum of Distances in Tree

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/sum-of-distances-in-tree/

---

## Problem Statement

There is an undirected connected tree with `n` nodes labeled from `0` to `n - 1` and `n - 1` edges. Given the integer `n` and the array `edges` where `edges[i] = [ai, bi]` indicates that there is an edge between nodes `ai` and `bi` in the tree, return an array `answer` of length `n` where `answer[i]` is the sum of the distances between the `i`th node and all other nodes.

---

## Examples

**Example 1:**
```
Input:  n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
Output: [8,12,6,10,10,10]
```

---

## Constraints

- `1 <= n <= 3 * 10^4`
- `edges.length == n - 1`
- `0 <= ai, bi < n`
- The given input represents a valid tree.
