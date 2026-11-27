# 210. Course Schedule II

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/course-schedule-ii/

---

## Problem Statement

There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses - 1`. You are given an array `prerequisites` where `prerequisites[i] = [a_i, b_i]` indicates that you **must** take course `b_i` first if you want to take course `a_i`.

Return the ordering of courses you should take to finish all courses. If there are many valid answers, return **any** of them. If it is impossible to finish all courses, return **an empty array**.

---

## Examples

**Example 1:**
```
Input:  numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are 2 courses. To take course 1 you should finish course 0 first.
             So the correct course order is [0,1].
```

**Example 2:**
```
Input:  numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are 4 courses. The correct course order is [0,1,2,3] or [0,2,1,3].
```

**Example 3:**
```
Input:  numCourses = 1, prerequisites = []
Output: [0]
```

---

## Constraints

- `1 <= numCourses <= 2000`
- `0 <= prerequisites.length <= numCourses * (numCourses - 1)`
- `prerequisites[i].length == 2`
- `0 <= a_i, b_i < numCourses`
- `a_i != b_i`
- All the pairs `[a_i, b_i]` are distinct
