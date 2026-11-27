# 2127. Maximum Employees to Be Invited to a Meeting

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/maximum-employees-to-be-invited-to-a-meeting/

## Problem

A company is organizing a meeting and has a list of `n` employees, waiting to be invited. They have arranged for a large circular table, capable of seating any number of employees.

The employees are numbered from `0` to `n - 1`. Each employee has a favorite person and they will attend the meeting only if they can sit next to their favorite person at the table. The favorite person of an employee is not themself.

Given a 0-indexed integer array `favorite`, where `favorite[i]` denotes the favorite person of the ith employee, return the maximum number of employees that can be invited to the meeting.

## Examples

**Example 1:**
```
Input: favorite = [2,2,1,2]
Output: 3
Explanation: Invite employees 0, 1, 2 (or 1, 2, 3). Employee 2 can't sit next to all of 0, 1, and 3.
```

**Example 2:**
```
Input: favorite = [1,2,0]
Output: 3
Explanation: All three employees can be seated in a circle since each is the other's favorite.
```

**Example 3:**
```
Input: favorite = [3,0,1,4,1]
Output: 4
Explanation: Invite employees 0, 1, 3, 4.
```

## Constraints

- `n == favorite.length`
- `2 <= n <= 10^5`
- `0 <= favorite[i] <= n - 1`
- `favorite[i] != i`
