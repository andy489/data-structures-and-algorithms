# 2973. Find Number of Coins to Place in Tree Nodes

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/find-number-of-coins-to-place-in-tree-nodes/

## Problem

You are given an undirected tree with n nodes labeled from 0 to n - 1, and rooted at node 0. You are given a 2D integer array edges of length n - 1, where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.

You are also given a 0-indexed integer array cost of length n, where cost[i] is the cost assigned to the ith node.

You need to place some coins on every node of the tree. The number of coins to be placed at node i can be calculated as:
- If size of the subtree of node i is less than 3, place 1 coin.
- Otherwise, place an amount of coins equal to the maximum product of cost values assigned to 3 distinct nodes in the subtree of node i. If this product is negative, place 0 coins.

Return an array coin of size n such that coin[i] is the number of coins placed at node i.

## Examples

**Example 1:**
```
Input: edges = [[0,1],[0,2],[0,3],[0,4],[0,5]], cost = [1,2,3,4,5,6]
Output: [120,1,1,1,1,1]
```

**Example 2:**
```
Input: edges = [[0,1],[0,2],[1,3],[1,4],[1,5],[2,6],[2,7],[2,8]], cost = [1,4,2,3,5,7,8,-4,2]
Output: [280,140,32,1,1,1,1,1,1]
```

**Example 3:**
```
Input: edges = [[0,1],[0,2]], cost = [1,2,-2]
Output: [0,1,1]
```

## Constraints

- `2 <= n <= 2 * 10^4`
- `edges.length == n - 1`
- `0 <= ai, bi < n`
- `cost.length == n`
- `1 <= |cost[i]| <= 10^4`
