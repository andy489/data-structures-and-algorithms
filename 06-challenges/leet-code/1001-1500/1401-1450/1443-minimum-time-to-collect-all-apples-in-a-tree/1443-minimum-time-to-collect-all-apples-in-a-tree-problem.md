# 1443. Minimum Time To Collect All Apples In A Tree

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/

---

## Problem Statement

Return minimum seconds to collect all apples in a tree rooted at 0. Moving between adjacent nodes takes 1 second.

---

## Examples

**Example 1:**
```
Input:  n=7,edges=[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]],hasApple=[false,false,true,false,true,true,false]
Output: 8
```

**Example 2:**
```
Input:  n=7,edges=[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]],hasApple=[false,false,true,false,false,true,false]
Output: 6
```

---

## Constraints

- `1 <= n <= 10^5`
- `edges.length == n-1`
- `0 <= ai, bi < n`
- `hasApple.length == n`
