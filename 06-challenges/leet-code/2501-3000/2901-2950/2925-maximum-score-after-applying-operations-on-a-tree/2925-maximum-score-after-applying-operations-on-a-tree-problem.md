# 2925. Maximum Score After Applying Operations on a Tree

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-score-after-applying-operations-on-a-tree/

---

## Problem Statement

There is an undirected tree with `n` nodes labeled from 0 to `n - 1`, and rooted at node 0. You are given a 2D integer array `edges` of length `n - 1`, where `edges[i] = [ai, bi]` indicates that there is an edge between nodes `ai` and `bi` in the tree.

You are also given a **0-indexed** integer array `values` of length `n`, where `values[i]` is the **value** associated with the `i`th node.

You start with a score of 0. In one operation, you choose a node `i`, **add** `values[i]` to your score, and then **set** `values[i]` to 0. All three steps happen together as a single operation.

A tree is **healthy** if, for **every** leaf node, the sum of the **current** values on the path from the root to that leaf is **not equal** to 0.

Return the **maximum score** you can obtain by performing this operation on the tree any number of times, so that the tree remains **healthy** at the end.

---

## Examples

**Example 1:**
```
Input: edges = [[0,1],[0,2],[0,3],[2,4],[4,5]], values = [5,2,5,2,1,1]
Output: 11
Explanation: We apply the operation to nodes 1, 2, 3, 4, and 5, so the values become [5,0,0,0,0,0]. The leaves are nodes 1, 3, and 5.
- The sum of values on the path from 0 to 1 is equal to 5.
- The sum of values on the path from 0 to 3 is equal to 5.
- The sum of values on the path from 0 to 5 is equal to 5.
Every leaf has a non-zero path sum, so the tree is healthy. The score is 2 + 5 + 2 + 1 + 1 = 11.
```

**Example 2:**
```
Input: edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]], values = [20,10,9,7,4,3,5]
Output: 40
Explanation: We apply the operation to nodes 0, 2, 3, and 4, so the values become [0,10,0,0,0,3,5]. The leaves are nodes 3, 4, 5, and 6.
Every leaf has a non-zero path sum. The score is 20 + 9 + 7 + 4 = 40.
```

---

## Constraints

- `2 <= n <= 2 * 10^4`
- `edges.length == n - 1`
- `edges[i].length == 2`
- `0 <= ai, bi < n`
- `values.length == n`
- `1 <= values[i] <= 10^9`
- The input is generated such that `edges` represents a valid tree.
