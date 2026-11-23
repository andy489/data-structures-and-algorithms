# 586. Customer Placing the Largest Number of Orders — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/

---

## Solution: GROUP BY + ORDER BY + LIMIT — O(n log n) time

**Idea:** Group by `customer_number`, count orders per customer, sort descending, and take the top 1.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
