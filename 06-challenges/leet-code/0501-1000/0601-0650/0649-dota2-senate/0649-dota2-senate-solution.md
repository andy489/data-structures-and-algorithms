# 649. Dota2 Senate — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/dota2-senate/

---

## Solution: Two Queues — O(n) time, O(n) space

**Idea:** Use two queues storing indices of R and D senators. Each round, the senator with the smaller index bans the other. The surviving senator is re-queued with index += n (simulating the next round).

**Algorithm:**
1. Enqueue indices of all 'R' and 'D' senators.
2. While both queues non-empty: compare front indices. Smaller wins; re-enqueue winner with index + n. Discard loser.
3. Return "Radiant" if R queue non-empty, else "Dire".

**Complexity:**

| | |
|---|---|
| Time | O(n) — each senator processed O(1) times |
| Space | O(n) — two queues |
