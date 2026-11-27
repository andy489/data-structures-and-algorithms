# 2050. Parallel Courses III

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/parallel-courses-iii/

---

## Problem Statement

You are given `n` courses (1-indexed) and a list of `relations` (prerequisite → next). `time[i]` = time to complete course `i`. Each course starts immediately when all prerequisites done. Return **minimum time** to complete all courses.

---

## Examples

**Example 1:**
```
Input:  n = 3, relations = [[1,3],[2,3]], time = [3,2,5]
Output: 8
```
Explanation: Courses 1 and 2 in parallel, then course 3.

**Example 2:**
```
Input:  n = 5, relations = [[1,5],[2,5],[3,5],[3,4],[4,5]], time = [1,2,3,4,5]
Output: 12
```

---

## Constraints

- `1 <= n <= 5 * 10^4`
- `0 <= relations.length <= min(n*(n-1)/2, 5*10^4)`
- `relations[i].length == 2`
- `1 <= time.length == n`
- `1 <= time[i] <= 10^4`
