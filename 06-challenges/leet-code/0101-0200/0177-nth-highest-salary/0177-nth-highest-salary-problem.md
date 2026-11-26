# 177. Nth Highest Salary

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/nth-highest-salary/

---

## Problem Statement

Write a solution to find the `n`th highest distinct salary from the `Employee` table. If there are fewer than `n` distinct salaries, return `null`.

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
n = 2

Output:
+------------------------+
| getNthHighestSalary(2) |
+------------------------+
| 200                    |
+------------------------+
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
n = 2

Output:
+------------------------+
| getNthHighestSalary(2) |
+------------------------+
| null                   |
+------------------------+
```

---

## Constraints

- `-2^31 <= salary <= 2^31 - 1`
- `n` is a positive integer.
