# 1489. Find Critical And Pseudo Critical Edges In Minimum Spanning Tree

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/

---

## Problem Statement

Return critical and pseudo-critical edges of the MST. Critical: removing it increases MST weight. Pseudo-critical: can be in some but not all MSTs.

---

## Examples

**Example 1:**
```
Input:  n=5,edges=[[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]
Output: [[0,1],[2,3,4,5]]
```

**Example 2:**
```
Input:  n=4,edges=[[0,1,1],[1,2,1],[0,2,1],[2,3,1]]
Output: [[],[0,1,2,3]]
```

---

## Constraints

- `2 <= n <= 100`
- `1 <= edges.length <= min(200, n*(n-1)/2)`
- `edges[i].length == 3`
- `0 <= fromi, toi < n`
- `1 <= weighti <= 1000`
