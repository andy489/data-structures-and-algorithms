# 1466. Reorder Routes To Make All Paths Lead To The City Zero

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/

---

## Problem Statement

Given a tree with n cities and n-1 directed edges, find the minimum number of edges to reverse to allow all cities to reach city 0.

---

## Examples

**Example 1:**
```
Input:  n=6,connections=[[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
```

**Example 2:**
```
Input:  n=5,connections=[[1,0],[1,2],[3,2],[3,4]]
Output: 2
```

---

## Constraints

- `2 <= n <= 5*10^4`
- `connections.length == n-1`
- `connections[i].length == 2`
- `0 <= ai, bi <= n-1`
- `ai != bi`
