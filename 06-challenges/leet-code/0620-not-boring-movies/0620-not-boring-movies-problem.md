# 620. Not Boring Movies

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/not-boring-movies/

---

## Problem Statement

Table `Cinema`:

```
+----------------+----------+
| Column Name    | Type     |
+----------------+----------+
| id             | int      |
| movie          | varchar  |
| description    | varchar  |
| rating         | float    |
+----------------+----------+
```

Write a solution to report the movies with an odd-numbered ID and a description that is not `"boring"`. Return the result table ordered by `rating` in **descending order**.

---

## Examples

**Example 1:**
```
Input:
Cinema table:
+----+------------+-------------+--------+
| id | movie      | description | rating |
+----+------------+-------------+--------+
| 1  | War        | great 3D    | 8.9    |
| 2  | Science    | fiction     | 8.5    |
| 3  | irish      | boring      | 6.2    |
| 4  | Ice song   | Fantacy     | 8.6    |
| 5  | House card | Interesting | 9.1    |
+----+------------+-------------+--------+

Output:
+----+------------+-------------+--------+
| id | movie      | description | rating |
+----+------------+-------------+--------+
| 5  | House card | Interesting | 9.1    |
| 1  | War        | great 3D    | 8.9    |
+----+------------+-------------+--------+
```

---

## Constraints

- `1 <= id <= 2000`
- `1 <= movie.length, description.length <= 100`
