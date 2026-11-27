# 183. Customers Who Never Order

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/customers-who-never-order/

---

## Problem Statement

**Table: Customers**

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
+-------------+---------+
```
`id` is the primary key.

**Table: Orders**

```
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| customerId  | int  |
+-------------+------+
```
`id` is the primary key. `customerId` is a foreign key to `Customers.id`.

Write a solution to find all customers who never order anything.

Return the result table in **any order**.

---

## Example

**Input:**
```
Customers: [[1,"Joe"],[2,"Henry"],[3,"Sam"],[4,"Max"]]
Orders: [[1,3],[2,1]]
```

**Output:**
```
+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+
```
