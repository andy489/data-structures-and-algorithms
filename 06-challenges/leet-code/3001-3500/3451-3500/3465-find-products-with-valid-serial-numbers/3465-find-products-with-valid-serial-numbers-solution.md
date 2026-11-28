# 3465. Find Products with Valid Serial Numbers — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-products-with-valid-serial-numbers/

---

## Solution: SQL Regex — O(n) time, O(n) space

**Idea:** Use REGEXP to match descriptions containing a valid serial number pattern: SN followed by exactly 4 digits, a hyphen, and exactly 4 more digits. The pattern must be bounded by non-digit characters or string boundaries.

**Algorithm:**
1. Use REGEXP with pattern `(^|[^0-9])SN[0-9]{4}-[0-9]{4}($|[^0-9])` to find descriptions containing a valid serial number.
2. Select matching products ordered by product_id ascending.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |

```sql
SELECT product_id, product_name, description
FROM products
WHERE description REGEXP '(^|[^[:alnum:]])SN[0-9]{4}-[0-9]{4}($|[^[:digit:]])'
ORDER BY product_id ASC;
```
