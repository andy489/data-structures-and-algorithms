# 802. Find Eventual Safe States

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-eventual-safe-states/

---

## Problem Statement

There is a directed graph of `n` nodes with each node labeled from `0` to `n - 1`. The graph is represented by a 0-indexed 2D integer array `graph` where `graph[i]` is an integer array of nodes adjacent to node `i`.

A node is a **terminal node** if there are no outgoing edges. A node is a **safe node** if every possible path starting from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

---

## Examples

**Example 1:**
```
Input:  graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
```

**Example 2:**
```
Input:  graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
Output: [4]
```

---

## Constraints

- `n == graph.length`
- `1 <= n <= 10^4`
- `0 <= graph[i].length <= n`
- `0 <= graph[i][j] <= n - 1`
- `graph[i]` is sorted in strictly increasing order.
- The graph may contain self-loops.
- The number of edges in the graph will be in the range `[1, 4 * 10^4]`.
