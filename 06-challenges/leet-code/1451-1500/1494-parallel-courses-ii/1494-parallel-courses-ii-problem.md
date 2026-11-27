# 1494. Parallel Courses Ii

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/parallel-courses-ii/

---

## Problem Statement

Return the min number of semesters to complete all n courses. Each semester you can take at most k courses. Take prerequisite courses first.

---

## Examples

**Example 1:**
```
Input:  n=4,dependencies=[[2,1],[3,1],[1,4]],k=2
Output: 3
```

**Example 2:**
```
Input:  n=5,dependencies=[[2,1],[3,1],[4,1],[1,5]],k=2
Output: 4
```

**Example 3:**
```
Input:  n=11,dependencies=[],k=2
Output: 6
```

---

## Constraints

- `1 <= n <= 15`
- `1 <= k <= n`
- `0 <= dependencies.length <= n*(n-1)/2`
- `1 <= prerequisite < course <= n`
