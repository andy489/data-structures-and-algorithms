# 1251. Average Selling Price

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/average-selling-price/

---

## Problem Statement

Table: `Prices`

```
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| product_id    | int     |
| start_date    | date    |
| end_date      | date    |
| price         | int     |
+---------------+---------+
```

`(product_id, start_date, end_date)` is the primary key for this table.

Table: `UnitsSold`

```
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| product_id    | int     |
| purchase_date | date    |
| units         | int     |
+---------------+---------+
```

Write an SQL query to find the average selling price for each product. `average_price` should be rounded to 2 decimal places. Return the result table in any order.

---

## Examples

**Example 1:**
```
Input: Prices table:
```
+------------+------------+------------+--------+
| product_id | start_date | end_date   | price  |
+------------+------------+------------+--------+
| 1          | 2019-02-17 | 2019-02-28 | 5      |
| 1          | 2019-03-01 | 2019-03-22 | 20     |
| 2          | 2019-02-01 | 2019-02-20 | 15     |
| 2          | 2019-02-21 | 2019-03-31 | 30     |
+------------+------------+------------+--------+
```
Output:
```
+------------+---------------+
| product_id | average_price |
+------------+---------------+
| 1          | 6.96          |
| 2          | 16.96         |
+------------+---------------+
```
```

---

## Constraints

- `Each product_id has non-overlapping date ranges`
- `Data is not null`
