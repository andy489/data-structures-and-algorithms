# 586. Customer Placing the Largest Number of Orders

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/

---

## Problem Statement

Table: `Orders`

```
+-----------------+----------+
| Column Name     | Type     |
+-----------------+----------+
| order_number    | int      |
| customer_number | int      |
+-----------------+----------+
```

`order_number` is the primary key. Each row contains information about an order and the customer.

Find the `customer_number` for the customer who has placed **the largest number of orders**.

The test cases are generated so that **exactly one customer** has placed more orders than any other customer.

---

## Examples

**Example 1:**
```
Input:
Orders table:
+--------------+-----------------+
| order_number | customer_number |
+--------------+-----------------+
| 1            | 1               |
| 2            | 2               |
| 3            | 3               |
| 4            | 3               |
+--------------+-----------------+

Output:
+-----------------+
| customer_number |
+-----------------+
| 3               |
+-----------------+
```
