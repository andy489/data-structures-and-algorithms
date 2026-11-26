# 1050. Actors and Directors Who Cooperated At Least Three Times — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/actors-and-directors-who-cooperated-at-least-three-times/

---

## Solution: SQL GROUP BY + HAVING — O(n) time, O(n) space

**Idea:** Group by (actor_id, director_id) and filter with HAVING COUNT >= 3.

**Algorithm:**
1. `SELECT actor_id, director_id FROM ActorDirector GROUP BY actor_id, director_id HAVING COUNT(*) >= 3`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
