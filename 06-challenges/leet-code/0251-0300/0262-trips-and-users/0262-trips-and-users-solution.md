# 262. Trips and Users — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/trips-and-users/

---

## Solution: SQL Join + Aggregation — O(n) time, O(n) space

**Idea:** Join Trips with Users twice (for client and driver), filter banned users and date range, aggregate per day.

**Algorithm:**
1. Join `Trips t` with `Users u1` on `t.client_id = u1.users_id` and `Users u2` on `t.driver_id = u2.users_id`.
2. Filter `u1.banned = 'No' AND u2.banned = 'No'`.
3. Filter `t.request_at BETWEEN '2013-10-01' AND '2013-10-03'`.
4. `GROUP BY t.request_at`, compute `ROUND(SUM(CASE WHEN t.status != 'completed' THEN 1 ELSE 0 END) / COUNT(*), 2)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
