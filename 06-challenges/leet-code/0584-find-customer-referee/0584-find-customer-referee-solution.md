# 584. Find Customer Referee — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-customer-referee/

---

## Solution: WHERE with NULL check — O(n) time

**Idea:** Select customers where `referee_id` is not 2. Must handle `NULL` explicitly since `NULL != 2` evaluates to `NULL` (not `TRUE`) in SQL.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
