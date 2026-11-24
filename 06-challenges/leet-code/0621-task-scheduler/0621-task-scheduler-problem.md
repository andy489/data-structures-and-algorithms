# 621. Task Scheduler

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/task-scheduler/

---

## Problem Statement

You are given an array of CPU `tasks`, each labeled with a letter from A to Z, and a number `n`. Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, but there is a constraint: there has to be a gap of **at least** `n` intervals between two tasks with the same label.

Return the **minimum** number of CPU intervals required to complete all the given tasks.

---

## Examples

**Example 1:**
```
Input:  tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B
```

**Example 2:**
```
Input:  tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
```

**Example 3:**
```
Input:  tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
```

---

## Constraints

- `1 <= tasks.length <= 10^4`
- `tasks[i]` is an uppercase English letter
- `0 <= n <= 100`
