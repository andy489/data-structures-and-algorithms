# 1211. Queries Quality and Percentage

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/queries-quality-and-percentage/

---

## Problem Statement

Table: `Queries`

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| query_name  | varchar |
| result      | varchar |
| position    | int     |
| rating      | int     |
+-------------+---------+
```

This table may have duplicate rows. This table contains information collected from some queries on a database. The `position` column has a value from 1 to 500. The `rating` column has a value from 1 to 5. Query with rating less than 3 is a poor query.

We define query quality as: The average of the ratio between query rating and its position.

We also define poor query percentage as: The percentage of all queries with rating less than 3.

Write an SQL query to find each `query_name`, the `quality` and `poor_query_percentage`.

Both quality and poor_query_percentage should be rounded to 2 decimal places. Return the result table in any order.

---

## Examples

**Example 1:**
```
Input: Queries table:
```
+------------+-------------------+----------+--------+
| query_name | result            | position | rating |
+------------+-------------------+----------+--------+
| Dog        | Golden Retriever  | 1        | 5      |
| Dog        | German Shepherd   | 2        | 5      |
| Dog        | Mule              | 200      | 1      |
| Cat        | Shirazi           | 5        | 2      |
| Cat        | Siamese           | 3        | 3      |
| Cat        | Sphynx            | 7        | 4      |
+------------+-------------------+----------+--------+
```
Output:
```
+------------+---------+-----------------------+
| query_name | quality | poor_query_percentage |
+------------+---------+-----------------------+
| Dog        | 2.50    | 33.33                 |
| Cat        | 0.66    | 33.33                 |
+------------+---------+-----------------------+
```
```

---

## Constraints

- `queries is not empty`
