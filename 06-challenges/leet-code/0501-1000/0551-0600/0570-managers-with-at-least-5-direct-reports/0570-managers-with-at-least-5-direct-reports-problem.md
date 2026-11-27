# 570. Managers with at Least 5 Direct Reports

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/managers-with-at-least-5-direct-reports/

---

## Problem Statement

Table: `Employee`

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
| department  | varchar |
| managerId   | int     |
+-------------+---------+
```
`id` is the primary key. Each row indicates the name of an employee, their department, and the id of their manager. If `managerId` is null, the employee has no manager.

No employee will be the manager of themselves.

Write a solution to find managers with at least **five direct reports**.

Return the result table in **any order**.

---

## Examples

**Example 1:**
```
Input:
Employee table:
+-----+-------+------------+-----------+
| id  | name  | department | managerId |
+-----+-------+------------+-----------+
| 101 | John  | A          | None      |
| 102 | Dan   | A          | 101       |
| 103 | James | A          | 101       |
| 104 | Amy   | A          | 101       |
| 105 | Anne  | A          | 101       |
| 106 | Ron   | B          | 101       |
+-----+-------+------------+-----------+
Output:
+------+
| name |
+------+
| John |
+------+
```

---

## Constraints

- Primary key is `id`
