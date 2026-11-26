# 585. Investments in 2016 — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/investments-in-2016/

---

## Solution: Subquery filtering — O(n) time

**Idea:** Use subqueries (or GROUP BY with HAVING) to identify:
1. Policyholders whose `tiv_2015` appears more than once.
2. Policyholders at a unique `(lat, lon)`.

Then sum `tiv_2016` for the intersection.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
