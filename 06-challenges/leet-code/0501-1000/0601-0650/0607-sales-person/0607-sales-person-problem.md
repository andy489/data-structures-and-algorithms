# 607. Sales Person

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/sales-person/

---

## Problem Statement

Table `SalesPerson`:

```
+-----------------+---------+
| Column Name     | Type    |
+-----------------+---------+
| sales_id        | int     |
| name            | varchar |
| salary          | int     |
| commission_rate | int     |
| hire_date       | date    |
+-----------------+---------+
```

Table `Company`:

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| com_id      | int     |
| name        | varchar |
| city        | varchar |
+-------------+---------+
```

Table `Orders`:

```
+-------------+------+
| Column Name | Type |
+-------------+------+
| order_id    | int  |
| order_date  | date |
| com_id      | int  |
| sales_id    | int  |
| amount      | int  |
+-------------+------+
```

Write a solution to find the names of all salespersons who did not have any orders related to the company with the name **"RED"**.

---

## Examples

**Example 1:**
```
Input:
SalesPerson table: [(1,'John',100000,6,'2006-04-01'),(2,'Amy',12000,5,'2010-05-01'),(3,'Mark',65000,12,'2008-12-25'),(4,'Pam',25000,25,'2005-01-01'),(5,'Alex',5000,10,'2007-02-03')]
Company table: [(1,'RED','Boston'),(2,'ORANGE','New York'),(3,'YELLOW','Boston'),(4,'GREEN','Austin')]
Orders table: [(1,'2014-01-01',3,4,10000),(2,'2014-02-01',4,5,5000),(3,'2014-03-01',1,1,50000),(4,'2014-04-01',1,4,25000)]

Output:
+------+
| name |
+------+
| Amy  |
| Mark |
| Alex |
+------+
```

---

## Constraints

- Each table's primary key is as described above
- All foreign keys are valid
