# 607. Sales Person — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/sales-person/

---

## Solution: NOT IN Subquery — O(n·m) time, O(n) space

**Idea:** Find sales_ids that have orders with RED company, then exclude those from SalesPerson.

**Algorithm:**
1. Find com_id of 'RED' from Company.
2. Find all sales_ids in Orders that placed orders with that com_id.
3. Return names from SalesPerson NOT in that set.

**Complexity:**

| | |
|---|---|
| Time | O(n·m) — subquery join |
| Space | O(n) — subquery result set |
