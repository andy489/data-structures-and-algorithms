# 630. Course Schedule III

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/course-schedule-iii/

---

## Problem Statement

There are `n` different online courses numbered from `1` to `n`. You are given an array `courses` where `courses[i] = [duration_i, lastDay_i]` indicate that the `i`th course should be taken **continuously** for `duration_i` days and must be finished before or on `lastDay_i`.

You will start on the `1st` day and you cannot take two courses simultaneously.

Return the **maximum** number of courses that you can take.

---

## Examples

**Example 1:**
```
Input:  courses = [[100,200],[200,1300],[1000,1250],[2000,3200]]
Output: 3
```

**Example 2:**
```
Input:  courses = [[1,2]]
Output: 1
```

**Example 3:**
```
Input:  courses = [[3,2],[4,3]]
Output: 0
```

---

## Constraints

- `1 <= courses.length <= 10^4`
- `1 <= duration_i, lastDay_i <= 2 * 10^4`
