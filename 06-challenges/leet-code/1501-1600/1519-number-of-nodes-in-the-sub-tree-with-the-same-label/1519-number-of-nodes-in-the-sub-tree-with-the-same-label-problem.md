# 1519. Number of Nodes in the Sub-Tree With the Same Label

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/

---

## Problem Statement

You are given a tree (i.e. a connected, undirected graph that has no cycles) consisting of `n` nodes numbered from `0` to `n - 1` and exactly `n - 1` edges. The root of the tree is the node `0`, and each node of the tree has a label which is a lower-case character given in the string `labels` (i.e. The label of the `i`th node is `labels[i]`).

The `edges` array is given on the form `edges[i] = [ai, bi]`, which means there is an edge between nodes `ai` and `bi` in the tree.

Return *an array of size `n`* where `ans[i]` is the number of nodes in the subtree of the `i`th node which have the same label as node `i`.

---

## Examples

**Example 1:**
```
Input:  n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], labels = "abaedcd"
Output: [2,1,1,1,1,1,1]
```

**Example 2:**
```
Input:  n = 4, edges = [[0,1],[1,2],[0,3]], labels = "bbbb"
Output: [4,2,1,1]
```

---

## Constraints

- `1 <= n <= 10^5`
- `edges.length == n - 1`
- `edges[i].length == 2`
- `0 <= ai, bi < n`
- `ai != bi`
- `labels.length == n`
- `labels` is consisting of only of lowercase English letters.
