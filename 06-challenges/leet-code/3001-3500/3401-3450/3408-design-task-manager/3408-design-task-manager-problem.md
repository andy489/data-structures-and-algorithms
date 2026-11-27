# 3408. Design Task Manager

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/design-task-manager/

## Problem

There is a task management system where each task is associated with a user and a priority. Implement the TaskManager class:

- **TaskManager(tasks)**: Initialize with a list of [userId, taskId, priority] triples.
- **add(userId, taskId, priority)**: Add a new task. taskId is guaranteed new.
- **edit(taskId, newPriority)**: Update task priority. taskId is guaranteed to exist.
- **rmv(taskId)**: Remove a task. taskId is guaranteed to exist.
- **execTop()**: Execute the task with highest priority (ties broken by highest taskId). Remove it and return its userId. Return -1 if no tasks.

## Examples

**Example 1:**

```
Input: ["TaskManager","add","edit","execTop","rmv","add","execTop"]
       [[[[1,101,10],[2,102,20],[3,103,15]]],[4,104,5],[102,8],[],[101],[5,105,15],[]]
Output: [null,null,null,3,null,null,5]
```

Explanation:
- Initialize with 3 tasks.
- Add task 104 for user 4 with priority 5.
- Edit task 102 priority to 8.
- execTop() returns 3 (task 103, priority 15).
- Remove task 101.
- Add task 105 for user 5 with priority 15.
- execTop() returns 5 (task 105, priority 15, highest taskId among ties).

## Constraints

- 1 <= tasks.length <= 10^5
- 0 <= userId, taskId <= 10^5
- 0 <= priority, newPriority <= 10^9
- At most 2 * 10^5 calls total to add, edit, rmv, execTop.
