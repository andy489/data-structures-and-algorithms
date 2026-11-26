# 1280. Students and Examinations

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/students-and-examinations/

---

## Problem Statement

Table: `Students`

```
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| student_id    | int     |
| student_name  | varchar |
+---------------+---------+
```

Table: `Subjects`

```
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| subject_name | varchar |
+--------------+---------+
```

Table: `Examinations`

```
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| student_id   | int     |
| subject_name | varchar |
+--------------+---------+
```

Write an SQL query to find the number of times each student attended each exam. Return the result table ordered by `student_id` and `subject_name`.

---

## Examples

**Example 1:**
```
Input: Students: [[1,'Alice'],[2,'Bob'],[13,'John'],[6,'Alex']], Subjects: [['Math'],['Physics'],['Programming']], Examinations: [[1,'Math'],[1,'Physics'],[1,'Programming'],[2,'Math'],[1,'Math'],[13,'Math'],[13,'Programming'],[13,'Physics'],[2,'Math'],[1,'Math']]
Output: student_id|student_name|subject_name|attended_exams sorted by student_id,subject_name
```

---

## Constraints

- `Tables are non-empty`
