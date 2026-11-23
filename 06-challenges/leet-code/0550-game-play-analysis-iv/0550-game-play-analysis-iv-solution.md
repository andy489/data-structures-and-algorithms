# 550. Game Play Analysis IV — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/game-play-analysis-iv/

---

## Solution: SQL — Fraction of Next-Day Logins

**Idea:** For each player, find their first login date. Then check how many also logged in the very next day. Divide by total distinct players.

**Algorithm:**
1. Subquery: `MIN(event_date)` per player.
2. Join back to `Activity` on `player_id` and `event_date = first_login + 1`.
3. `ROUND(COUNT(DISTINCT ...) / (SELECT COUNT(DISTINCT player_id) FROM Activity), 2)`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — grouping and join |
| Space | O(n) — aggregation |
