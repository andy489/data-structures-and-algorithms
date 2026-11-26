# 1407. Top Travellers — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/top-travellers/

---

## Solution: LEFT JOIN + GROUP BY + COALESCE — O(n) time, O(n) space

**Idea:** LEFT JOIN users with rides to include users with no trips. Use COALESCE for null distances.

**Algorithm:**
1. LEFT JOIN Rides on Users.id = Rides.user_id.
2. GROUP BY user id, sum distance with COALESCE(SUM(distance),0).
3. ORDER BY distance DESC, name ASC.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
