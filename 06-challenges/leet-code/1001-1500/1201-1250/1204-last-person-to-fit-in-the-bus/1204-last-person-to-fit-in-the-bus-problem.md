# 1204. Last Person to Fit in the Bus

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/last-person-to-fit-in-the-bus/

---

## Problem Statement

Table: `Queue`

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| person_id   | int     |
| person_name | varchar |
| weight      | int     |
| turn        | int     |
+-------------+---------+
```

`person_id` is the primary key column for this table. This table has the information about all people waiting for a bus. The `weight` of the person is in kilograms. `turn` is the order in which they will board the bus.

There is a queue of people waiting to board a bus. However, the bus has a weight limit of `1000` kilograms, so there may be some people who cannot board.

Write an SQL query to find the `person_name` of the last person that can fit on the bus without exceeding the weight limit. The test cases are generated such that the first person does not exceed the weight limit.

---

## Examples

**Example 1:**
```
Input: Queue table:
```
+-----------+-------------+--------+------+
| person_id | person_name | weight | turn |
+-----------+-------------+--------+------+
| 5         | Alice       | 250    | 1    |
| 4         | Bob         | 175    | 5    |
| 3         | Alex        | 350    | 2    |
| 6         | John Cena   | 400    | 3    |
| 1         | Winston     | 500    | 6    |
| 2         | Marie       | 200    | 4    |
+-----------+-------------+--------+------+
```
Output:
```
+-------------------+
| person_name       |
+-------------------+
| John Cena         |
+-------------------+
```
```

---

## Constraints

- `1 <= Queue.length <= 1000`
- `1 <= turn <= Queue.length`
- `No two people have the same turn value`
