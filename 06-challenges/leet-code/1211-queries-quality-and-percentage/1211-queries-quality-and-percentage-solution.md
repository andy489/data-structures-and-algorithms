# 1211. Queries Quality and Percentage — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/queries-quality-and-percentage/

---

## Solution: GROUP BY with AVG and CASE — O(n) time, O(n) space

**Idea:** Use GROUP BY query_name, computing AVG(rating/position) for quality and AVG(CASE WHEN rating<3 THEN 1 ELSE 0 END)*100 for poor_query_percentage.

**Algorithm:**
1. Group by query_name.
2. quality = ROUND(AVG(rating/position), 2).
3. poor_query_percentage = ROUND(AVG(CASE WHEN rating < 3 THEN 1 ELSE 0 END) * 100, 2).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |


**SQL Solution:**
```sql
SELECT query_name,
       ROUND(AVG(rating / position), 2) AS quality,
       ROUND(AVG(CASE WHEN rating < 3 THEN 1 ELSE 0 END) * 100, 2) AS poor_query_percentage
FROM Queries
WHERE query_name IS NOT NULL
GROUP BY query_name;
```