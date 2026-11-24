# 627. Swap Salary

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/swap-salary/

---

## Problem Statement

Table `Salary`:

```
+-------------+----------+
| Column Name | Type     |
+-------------+----------+
| id          | int      |
| name        | varchar  |
| sex         | ENUM     |
| salary      | int      |
+-------------+----------+
```

`id` is the primary key. The `sex` column is an ENUM value of type `('m', 'f')`.

Write a single **update** statement and do not use any intermediate temporary tables to swap all `'f'` and `'m'` values (i.e., change all `'f'` values to `'m'` and vice versa) with a single update statement and no intermediate temp table.

---

## Examples

**Example 1:**
```
Input:
Salary table:
+----+------+-----+--------+
| id | name | sex | salary |
+----+------+-----+--------+
| 1  | A    | m   | 2500   |
| 2  | B    | f   | 1500   |
| 3  | C    | m   | 5500   |
| 4  | D    | f   | 500    |
+----+------+-----+--------+

Output:
+----+------+-----+--------+
| id | name | sex | salary |
+----+------+-----+--------+
| 1  | A    | f   | 2500   |
| 2  | B    | m   | 1500   |
| 3  | C    | f   | 5500   |
| 4  | D    | m   | 500    |
+----+------+-----+--------+
```

---

## Constraints

- `1 <= Salary.id <= 100`
- Salary has no duplicate values
