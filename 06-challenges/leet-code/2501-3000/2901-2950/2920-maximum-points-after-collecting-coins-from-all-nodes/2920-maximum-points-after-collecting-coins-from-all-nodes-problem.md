# 2920. Maximum Points After Collecting Coins From All Nodes

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-points-after-collecting-coins-from-all-nodes/

---

## Problem Statement

There exists an undirected tree rooted at node `0` with `n` nodes labeled `0` to `n - 1`. You are given a 2D integer array `edges` of length `n - 1`, where `edges[i] = [ai, bi]` indicates an edge between nodes `ai` and `bi`. You are also given a **0-indexed** array `coins` of size `n` where `coins[i]` indicates the number of coins in vertex `i`, and an integer `k`.

Starting from the root, you have to collect all the coins such that the coins at a node can only be collected if the coins of its ancestors have been already collected.

Coins at `node_i` can be collected in one of the following ways:
- Collect all the coins, but you will get `coins[i] - k` points (can be negative).
- Collect all the coins, but you will get `floor(coins[i] / 2)` points. If this way is used, then for all `node_j` present in the subtree of `node_i`, `coins[j]` will get reduced to `floor(coins[j] / 2)`.

Return the **maximum points** you can get after collecting the coins from all the tree nodes.

---

## Examples

**Example 1:**
```
Input: edges = [[0,1],[1,2],[2,3]], coins = [10,10,3,3], k = 5
Output: 11
```

**Example 2:**
```
Input: edges = [[0,1],[0,2]], coins = [8,4,4], k = 0
Output: 16
```

---

## Constraints

- `n == coins.length`
- `2 <= n <= 10^5`
- `0 <= coins[i] <= 10^4`
- `edges.length == n - 1`
- `0 <= edges[i][0], edges[i][1] < n`
- `0 <= k <= 10^4`
