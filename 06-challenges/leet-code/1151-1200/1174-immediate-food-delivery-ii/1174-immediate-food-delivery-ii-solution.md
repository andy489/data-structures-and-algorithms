# 1174. Immediate Food Delivery II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/immediate-food-delivery-ii/

---

## Solution: SQL

```sql
SELECT ROUND(100 * SUM(order_date = customer_pref_delivery_date) / COUNT(*), 2) AS immediate_percentage FROM Delivery WHERE (customer_id, order_date) IN (SELECT customer_id, MIN(order_date) FROM Delivery GROUP BY customer_id)
```

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
