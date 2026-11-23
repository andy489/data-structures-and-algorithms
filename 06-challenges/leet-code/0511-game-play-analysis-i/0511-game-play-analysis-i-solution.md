# 511. Game Play Analysis I — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/game-play-analysis-i/

---

## Solution: GROUP BY with MIN — O(n) time, O(n) space

**Idea:** Group rows by player_id and select the minimum event_date for each group.

**Algorithm:**
1. `GROUP BY player_id`
2. `SELECT player_id, MIN(event_date) AS first_login`

**Complexity:**

| | |
|---|---|
| Time | O(n) — single table scan |
| Space | O(n) — group aggregation |
