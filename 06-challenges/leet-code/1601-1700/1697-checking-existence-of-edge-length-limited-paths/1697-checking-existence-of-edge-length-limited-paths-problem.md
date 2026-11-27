# 1697. Checking Existence of Edge Length Limited Paths

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/

---

## Problem Statement

An undirected graph of `n` nodes is defined by `edgeList`, where `edgeList[i] = [u_i, v_i, dis_i]` denotes an edge between nodes `u_i` and `v_i` with distance `dis_i`. Note that there may be **multiple** edges between two nodes.

Given an array `queries`, where `queries[j] = [p_j, q_j, limit_j]`, your task is to determine for each `queries[j]` whether there is a path between `p_j` and `q_j` such that each edge on the path has a distance **strictly less than** `limit_j`.

Return a **boolean array** `answer`, where `answer.length == queries.length` and the `j`-th value of `answer` is `true` if there is a path for `queries[j]` is `true`, and `false` otherwise.

---

## Examples

**Example 1:**
```
Input: n = 3, edgeList = [[0,1,2],[1,2,4],[2,0,8],[1,0,16]], queries = [[0,1,2],[0,2,5]]
Output: [false,true]
Explanation: The above figure shows the given graph. Note that there are two overlapping edges between 0 and 1 with distances 2 and 16.
For the first query, we need a path from 0 to 1 of edges < 2. No such path.
For the second query, the path 0->1->2 has edges 2 and 4, both < 5.
```

**Example 2:**
```
Input: n = 5, edgeList = [[0,1,10],[1,2,5],[2,3,9],[3,4,13]], queries = [[0,4,14],[1,4,13]]
Output: [true,false]
```

---

## Constraints

- `2 <= n <= 10^5`
- `1 <= edgeList.length, queries.length <= 10^5`
- `edgeList[i].length == 3`
- `queries[j].length == 3`
- `0 <= u_i, v_i, p_j, q_j <= n - 1`
- `u_i != v_i`
- `p_j != q_j`
- `1 <= dis_i, limit_j <= 10^9`
