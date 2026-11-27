# 174. Dungeon Game — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/dungeon-game/

---

## Solution: DP from Bottom-Right — O(m·n) time, O(m·n) space

**Idea:** Define `dp[i][j]` = minimum health needed **upon entering** cell `(i,j)` to eventually reach the bottom-right alive. Work backwards from the princess cell.

- Base: `dp[m-1][n-1] = max(1, 1 - dungeon[m-1][n-1])` (need at least 1 health).
- Transition: the minimum health needed after leaving `(i,j)` is `min(dp[i+1][j], dp[i][j+1])` (call it `need`). The health needed upon entering is `max(1, need - dungeon[i][j])`.
- Answer: `dp[0][0]`.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) |
| Space | O(m·n) — reducible to O(n) with 1D rolling array |

---

## Solution 2: O(n) Space Rolling Array

Same recurrence but only keep one row (bottom-up, right-to-left).
