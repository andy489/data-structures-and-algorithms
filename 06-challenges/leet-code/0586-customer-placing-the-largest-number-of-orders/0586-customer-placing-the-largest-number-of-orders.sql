-- https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/
SELECT customer_number
FROM Orders
GROUP BY customer_number
ORDER BY COUNT(*) DESC
LIMIT 1;
