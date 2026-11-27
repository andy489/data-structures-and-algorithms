# 1654. Minimum Jumps to Reach Home — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-jumps-to-reach-home/

---

## Solution: BFS — O(LIMIT) time, O(LIMIT) space

**Idea:** BFS on positions, tracking whether the last move was a backward jump. The upper bound for positions is `max(forbidden) + a + b` (beyond this, it's always better to come back via a backward jump).

**State:** `(position, lastWasBackward)`

**Algorithm:**
1. Put all forbidden positions in a set.
2. BFS starting from `(0, false)`.
3. At each state `(pos, back)`:
   - Try forward jump to `pos + a`: valid if not forbidden and within limit.
   - Try backward jump to `pos - b`: valid if not forbidden, `pos - b > 0`, and `back == false`.
4. Return the step count when we reach `x`.

**Complexity:**

| | |
|---|---|
| Time | O(LIMIT) where LIMIT = max(forbidden) + a + b |
| Space | O(LIMIT) |
