# 2049. Count Nodes With the Highest Score

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-nodes-with-the-highest-score/

---

## Problem Statement

Given a binary tree with `n` nodes. Each node `i` has children specified by `parents`. When a node is deleted, the tree splits into at most 3 components. Find the **maximum score** (product of sizes of all resulting components) and count how many nodes achieve it.

---

## Examples

**Example 1:**
```
Input:  parents = [-1,2,0,2,0]
Output: 3
```
Explanation: Nodes 2,3,4 each give score 2. Actually max is 3 from node 1.

**Example 2:**
```
Input:  parents = [-1,2,0,2,4,0]
Output: 2
```

---

## Constraints

- `n == parents.length`
- `2 <= n <= 10^5`
- `parents[0] == -1`
- `0 <= parents[i] <= n - 1 for i != 0`
- `parents represents a valid binary tree.`
