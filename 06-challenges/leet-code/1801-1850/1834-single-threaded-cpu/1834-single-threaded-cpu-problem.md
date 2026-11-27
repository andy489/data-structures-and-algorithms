# 1834. Single-Threaded CPU

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/single-threaded-cpu/

---

## Problem Statement

You are given `n` tasks labeled from `0` to `n - 1` represented by a 2D integer array `tasks`, where `tasks[i] = [enqueueTime_i, processingTime_i]` means that the `i`th task will be available to process at `enqueueTime_i` and will take `processingTime_i` to finish processing.

You have a single-threaded CPU that can process **at most one** task at a time and will act in the following way:

- If the CPU is idle and there are no available tasks to process, the CPU waits until the next task becomes available.
- If the CPU is idle and there are available tasks, the CPU will choose the one with the **shortest processing time**. If multiple tasks have the same shortest processing time, it will choose the task with the smallest index.
- Once a task is started, the CPU will process the entire task without stopping.
- The CPU can finish a task then immediately start a new one.

Return *the order in which the CPU will process the tasks.*

---

## Examples

**Example 1:**
```
Input: tasks = [[1,2],[2,4],[3,2],[4,1]]
Output: [0,2,3,1]
Explanation: The events go as follows:
- At time 1, task 0 is available. Available tasks = {0}. CPU starts task 0.
- At time 2, task 1 is available. CPU is busy. Available tasks = {1}.
- At time 3, task 0 finishes and task 2 is available. Available tasks = {1, 2}. CPU starts task 2 (shortest).
- At time 4, task 3 is available. CPU is busy. Available tasks = {1, 3}.
- At time 5, task 2 finishes. Available tasks = {1, 3}. CPU starts task 3 (shortest).
- At time 6, task 3 finishes. Available tasks = {1}. CPU starts task 1.
- At time 10, task 1 finishes.
```

**Example 2:**
```
Input: tasks = [[7,10],[7,12],[7,5],[7,4],[7,2]]
Output: [4,3,2,0,1]
```

---

## Constraints

- `tasks.length == n`
- `1 <= n <= 10^5`
- `1 <= enqueueTime_i, processingTime_i <= 10^9`
