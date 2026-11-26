# 610. Triangle Judgement

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/triangle-judgement/

---

## Problem Statement

Table `Triangle`:

```
+-------------+------+
| Column Name | Type |
+-------------+------+
| x           | int  |
| y           | int  |
| z           | int  |
+-------------+------+
```

`(x, y, z)` is the primary key. Each row contains the lengths of three line segments.

Write a solution to report for every three line segments whether they can form a triangle.

Return the result table in **any order**.

---

## Examples

**Example 1:**
```
Input:
Triangle table:
+----+----+----+
| x  | y  | z  |
+----+----+----+
| 13 | 15 | 30 |
| 10 | 20 | 15 |
+----+----+----+

Output:
+----+----+----+----------+
| x  | y  | z  | triangle |
+----+----+----+----------+
| 13 | 15 | 30 | No       |
| 10 | 20 | 15 | Yes      |
+----+----+----+----------+
```

---

## Constraints

- `1 <= x, y, z <= 100`
