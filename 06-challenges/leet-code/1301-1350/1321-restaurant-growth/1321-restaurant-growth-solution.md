# 1321. Restaurant Growth — Solution

## Approach
Use window function SUM with RANGE BETWEEN 6 PRECEDING AND CURRENT ROW after grouping by visited_on.

## SQL Solution
```sql
SELECT visited_on,
       SUM(daily) OVER (ORDER BY visited_on ROWS BETWEEN 6 PRECEDING AND CURRENT ROW) AS amount,
       ROUND(AVG(daily) OVER (ORDER BY visited_on ROWS BETWEEN 6 PRECEDING AND CURRENT ROW), 2) AS average_amount
FROM (
    SELECT visited_on, SUM(amount) AS daily
    FROM Customer
    GROUP BY visited_on
) t
ORDER BY visited_on
OFFSET 6 ROWS;
```
