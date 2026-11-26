# 1068. Product Sales Analysis I — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/product-sales-analysis-i/

---

## Solution: SQL

```sql
SELECT p.product_name, s.year, s.price FROM Sales s JOIN Product p ON s.product_id = p.product_id
```

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
