# 176. Second Highest Salary

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/second-highest-salary/

---

## Problem Statement

Write a solution to find the second highest distinct salary from the `Employee` table. If there is no second highest salary, return `null` (return `None` in Pandas).

**Table: Employee**

```
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| salary      | int  |
+-------------+------+
id is the primary key.
```

---

## Examples

**Example 1:**
```
Input:
Employee table:
+----+--------+
| id | salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+

Output:
+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+
```

**Example 2:**
```
Input:
Employee table:
+----+--------+
| id | salary |
+----+--------+
| 1  | 100    |
+----+--------+

Output:
+---------------------+
| SecondHighestSalary |
+---------------------+
| null                |
+---------------------+
```

---

## Constraints

- There are no duplicate `id` values.
- `salary` values are integers.
