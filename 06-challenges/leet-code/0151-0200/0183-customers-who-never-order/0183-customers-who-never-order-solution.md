# 183. Customers Who Never Order — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/customers-who-never-order/

---

## Solution: LEFT JOIN or NOT IN subquery

**Idea:** Find customers whose `id` does not appear in the `Orders.customerId` column. Use either a `LEFT JOIN` with a `NULL` check, or a `NOT IN` subquery.
