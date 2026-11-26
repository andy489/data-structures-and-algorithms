# 596. Classes with at Least 5 Students

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/classes-with-at-least-5-students/

---

## Problem Statement

Table: `Courses`

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| student     | varchar |
| class       | varchar |
+-------------+---------+
```

`(student, class)` is the primary key. Each row indicates the name of a student and the class in which they are enrolled.

Write a solution to find all the classes that have **at least five students**.

Return the result table in **any order**.

---

## Examples

**Example 1:**
```
Input:
Courses table:
+---------+----------+
| student | class    |
+---------+----------+
| A       | Math     |
| B       | English  |
| C       | Math     |
| D       | Biology  |
| E       | Math     |
| F       | Computer |
| G       | Math     |
| H       | Math     |
| I       | Math     |
+---------+----------+

Output:
+---------+
| class   |
+---------+
| Math    |
+---------+
```
