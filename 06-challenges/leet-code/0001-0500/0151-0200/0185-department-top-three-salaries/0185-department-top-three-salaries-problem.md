# 185. Department Top Three Salaries

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/department-top-three-salaries/

---

## Problem Statement

A company's executives are interested in seeing who earns the most money in each of the company's departments. A **high earner** is an employee who has a salary in the **top three unique** salaries in a department.

Write a solution to find the employees who are **high earners** in each of the departments.

Return the result table in **any order**.

**Tables:** `Employee(id, name, salary, departmentId)` and `Department(id, name)`.

---

## Example

**Output:**
```
+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| IT         | Joe      | 85000  |
| IT         | Randy    | 85000  |
| IT         | Will     | 70000  |
| Sales      | Henry    | 80000  |
| Sales      | Sam      | 60000  |
+------------+----------+--------+
```
