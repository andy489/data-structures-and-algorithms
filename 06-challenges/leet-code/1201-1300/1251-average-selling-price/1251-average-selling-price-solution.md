# 1251. Average Selling Price — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/average-selling-price/

---

## Solution: JOIN + Weighted Average — O(n*m) time, O(n) space

**Idea:** Join Prices and UnitsSold on product_id where purchase_date is within the price range. Compute weighted average price.

**Algorithm:**
1. JOIN on product_id and purchase_date BETWEEN start_date AND end_date.
2. GROUP BY product_id.
3. ROUND(SUM(price*units)/SUM(units), 2) as average_price.

**Complexity:**

| | |
|---|---|
| Time | O(n*m) |
| Space | O(n) |


**SQL Solution:**
```sql
SELECT p.product_id,
       IFNULL(ROUND(SUM(p.price * u.units) / SUM(u.units), 2), 0) AS average_price
FROM Prices p
LEFT JOIN UnitsSold u ON p.product_id = u.product_id
    AND u.purchase_date BETWEEN p.start_date AND p.end_date
GROUP BY p.product_id;
```