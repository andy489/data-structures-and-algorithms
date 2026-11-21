# 181. Employees Earning More Than Their Managers

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/employees-earning-more-than-their-managers/

---

## Problem Statement

Table: `Employee`

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
| salary      | int     |
| managerId   | int     |
+-------------+---------+
```

`id` is the primary key (column with unique values) for this table.
Each row of this table indicates the ID of an employee, their name, salary, and the ID of their manager.

Write a solution to find the employees who earn more than their managers.

Return the result table in any order.

---

## Examples

**Example 1:**
```
Input:
Employee table:
+----+-------+--------+-----------+
| id | name  | salary | managerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | null      |
| 4  | Max   | 90000  | null      |
+----+-------+--------+-----------+

Output:
+----------+
| Employee |
+----------+
| Joe      |
+----------+
```

**Explanation:** Joe is the only employee who earns more than his manager.

---

## Constraints

- `1 <= Employee.id <= 10^4`
- `0 <= salary <= 10^6`
- `managerId` is `null` or a valid employee `id`.
