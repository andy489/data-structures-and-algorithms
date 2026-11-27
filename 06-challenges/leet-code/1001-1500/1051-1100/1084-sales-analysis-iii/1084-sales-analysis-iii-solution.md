# 1084. Sales Analysis III — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/sales-analysis-iii/

---

## Solution: SQL

```sql
SELECT s.product_id, p.product_name FROM Sales s JOIN Product p ON s.product_id = p.product_id GROUP BY s.product_id HAVING MIN(sale_date) >= '2019-01-01' AND MAX(sale_date) <= '2019-03-31'
```

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
