# 1070. Product Sales Analysis III — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/product-sales-analysis-iii/

---

## Solution: SQL

```sql
SELECT product_id, year AS first_year, quantity, price FROM Sales WHERE (product_id, year) IN (SELECT product_id, MIN(year) FROM Sales GROUP BY product_id)
```

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
