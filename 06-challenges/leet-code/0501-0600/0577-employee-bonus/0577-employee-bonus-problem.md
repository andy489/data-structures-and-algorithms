# 577. Employee Bonus

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/employee-bonus/

---

## Problem Statement

Table: `Employee`

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| empId       | int     |
| name        | varchar |
| supervisor  | int     |
| salary      | int     |
+-------------+---------+
```
`empId` is the primary key.

Table: `Bonus`

```
+-------------+------+
| Column Name | Type |
+-------------+------+
| empId       | int  |
| bonus       | int  |
+-------------+------+
```
`empId` is the primary key; `empId` is a foreign key referencing `Employee`.

Write a solution to report the name and bonus amount of each employee with a bonus **less than** `1000`. If an employee does not have a bonus, include them with a `null` bonus.

Return the result table in **any order**.

---

## Examples

**Example 1:**
```
Input:
Employee: empId=3,name=Brad,supervisor=null,salary=4000
          empId=1,name=John,supervisor=3,salary=1000
          empId=2,name=Dan,supervisor=3,salary=2000
          empId=4,name=Thomas,supervisor=3,salary=4000
Bonus: empId=2,bonus=500
       empId=4,bonus=2000
Output:
+------+-------+
| name | bonus |
+------+-------+
| Brad | null  |
| John | null  |
| Dan  | 500   |
+------+-------+
```

---

## Constraints

- Primary key of Employee is `empId`
- Primary key of Bonus is `empId`
