# 626. Exchange Seats

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/exchange-seats/

---

## Problem Statement

Table `Seat`:

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| student     | varchar |
+-------------+---------+
```

`id` is the primary key (unique value). Each row indicates the name and the id of a student. `id` is a continuous increment.

Write a solution to swap the seat id of every two consecutive students. If the number of students is odd, the id of the last student is not swapped.

Return the result table ordered by `id` **ascending**.

---

## Examples

**Example 1:**
```
Input:
Seat table:
+----+---------+
| id | student |
+----+---------+
| 1  | Abbot   |
| 2  | Doris   |
| 3  | Emerson |
| 4  | Green   |
| 5  | Jeames  |
+----+---------+

Output:
+----+---------+
| id | student |
+----+---------+
| 1  | Doris   |
| 2  | Abbot   |
| 3  | Green   |
| 4  | Emerson |
| 5  | Jeames  |
+----+---------+
```

---

## Constraints

- `1 <= id <= 100`
- Each row has a unique `id`
