# 1484. Group Sold Products By The Date — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/group-sold-products-by-the-date/

---

## Solution: GROUP BY + GROUP_CONCAT — O(n log n) time, O(n) space

**Idea:** Group by sell_date. Use GROUP_CONCAT with DISTINCT and ORDER BY to list products.

**Algorithm:**
1. GROUP BY sell_date.
2. COUNT(DISTINCT product), GROUP_CONCAT(DISTINCT product ORDER BY product) for products list.
3. ORDER BY sell_date.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
