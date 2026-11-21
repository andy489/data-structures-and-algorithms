# 184. Department Highest Salary

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/department-highest-salary/

---

## Problem Statement

**Table: Employee**

```
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| id           | int     |
| name         | varchar |
| salary       | int     |
| departmentId | int     |
+--------------+---------+
```

**Table: Department**

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
+-------------+---------+
```

Write a solution to find employees who have the highest salary in each of the departments.

Return the result table in **any order**.

---

## Example

**Output:**
```
+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| IT         | Randy    | 85000  |
| Sales      | Henry    | 80000  |
+------------+----------+--------+
```
