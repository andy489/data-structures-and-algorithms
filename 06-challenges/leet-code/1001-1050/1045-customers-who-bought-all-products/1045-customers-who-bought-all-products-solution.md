# 1045. Customers Who Bought All Products — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/customers-who-bought-all-products/

---

## Solution: SQL GROUP BY + HAVING COUNT — O(n) time, O(n) space

**Idea:** Group by customer_id and filter those whose count of distinct product_keys equals the total number of products.

**Algorithm:**
1. `SELECT customer_id FROM Customer GROUP BY customer_id HAVING COUNT(DISTINCT product_key) = (SELECT COUNT(*) FROM Product)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
