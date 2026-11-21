# 197. Rising Temperature

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/rising-temperature/

---

## Problem Statement

**Table: Weather**

```
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| recordDate    | date    |
| temperature   | int     |
+---------------+---------+
```
`id` is the column with unique values. There are no duplicate `recordDate` values.

Write a solution to find all dates' `id` with higher temperatures compared to its previous dates (yesterday).

Return the result table in **any order**.

---

## Example

**Input:**
```
Weather: [[1,"2015-01-01",10],[2,"2015-01-02",25],[3,"2015-01-03",20],[4,"2015-01-04",30]]
```

**Output:**
```
+----+
| id |
+----+
| 2  |
| 4  |
+----+
```
