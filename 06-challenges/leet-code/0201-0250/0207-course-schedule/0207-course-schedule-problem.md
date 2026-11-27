# 207. Course Schedule

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/course-schedule/

---

## Problem Statement

There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses - 1`. You are given an array `prerequisites` where `prerequisites[i] = [a_i, b_i]` indicates that you **must** take course `b_i` first if you want to take course `a_i`.

Return `true` if you can finish all courses. Otherwise, return `false`.

---

## Examples

**Example 1:**
```
Input:  numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are 2 courses. To take course 1 you should have finished course 0.
             So it is possible.
```

**Example 2:**
```
Input:  numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are 2 courses. To take course 1 you should have finished course 0,
             and to take course 0 you should have finished course 1. So it is impossible.
```

---

## Constraints

- `1 <= numCourses <= 2000`
- `0 <= prerequisites.length <= 5000`
- `prerequisites[i].length == 2`
- `0 <= a_i, b_i < numCourses`
- All the pairs `prerequisites[i]` are unique
