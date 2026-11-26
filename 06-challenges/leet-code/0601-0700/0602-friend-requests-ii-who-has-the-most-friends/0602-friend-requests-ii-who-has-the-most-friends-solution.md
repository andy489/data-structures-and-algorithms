# 602. Friend Requests II: Who Has the Most Friends — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/friend-requests-ii-who-has-the-most-friends/

---

## Solution: UNION ALL + GROUP BY — O(n) time, O(n) space

**Idea:** Each accepted request creates a friendship for both sides. Union requester_ids and accepter_ids, then count per person and pick the max.

**Algorithm:**
1. UNION ALL of requester_id and accepter_id (both roles count as a friend).
2. GROUP BY id, COUNT(*) as num.
3. ORDER BY num DESC LIMIT 1.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single scan |
| Space | O(n) — union result |
