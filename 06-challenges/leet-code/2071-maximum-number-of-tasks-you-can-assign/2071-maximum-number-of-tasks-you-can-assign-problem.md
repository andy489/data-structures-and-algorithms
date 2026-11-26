# 2071. Maximum Number of Tasks You Can Assign

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign/

---

## Problem Statement

You have `n` tasks with `tasks[i]` minimum strength needed and `m` workers with `workers[j]` strength. Each task can use a magic pill (+`strength` to one worker). Assign the maximum number of tasks (easiest tasks to weakest capable workers).

---

## Examples

**Example 1:**
```
Input:  tasks = [3,2,1], workers = [0,3,3], pills = 1, strength = 1
Output: 3
```

**Example 2:**
```
Input:  tasks = [5,4], workers = [0,0,0], pills = 1, strength = 5
Output: 1
```

**Example 3:**
```
Input:  tasks = [10,15,30], workers = [0,10,10,10,10], pills = 3, strength = 10
Output: 2
```

---

## Constraints

- `n == tasks.length`
- `m == workers.length`
- `1 <= n, m <= 5 * 10^4`
- `0 <= pills <= m`
- `0 <= workers[j], strength <= 10^9`
- `1 <= tasks[i] <= 10^9`
