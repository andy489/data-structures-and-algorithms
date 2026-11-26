# 1462. Course Schedule Iv

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/course-schedule-iv/

---

## Problem Statement

Given prerequisites pairs and queries [u,v], return for each query whether course u is a prerequisite of v (directly or indirectly).

---

## Examples

**Example 1:**
```
Input:  numCourses=2,prerequisites=[[1,0]],queries=[[0,1],[1,0]]
Output: [false,true]
```

**Example 2:**
```
Input:  numCourses=4,prerequisites=[[2,3],[2,1],[0,2]],queries=[[2,1],[2,3],[3,2]]
Output: [true,true,false]
```

---

## Constraints

- `2 <= numCourses <= 100`
- `0 <= prerequisites.length <= (numCourses * (numCourses - 1) / 2)`
- `0 <= queries.length <= 10^4`
