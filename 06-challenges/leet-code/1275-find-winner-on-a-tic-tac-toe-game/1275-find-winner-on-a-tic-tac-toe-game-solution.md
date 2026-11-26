# 1275. Find Winner on a Tic Tac Toe Game — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/

---

## Solution: Score Arrays — O(1) time, O(1) space

**Idea:** Track score for rows, cols, and diagonals for each player. Win when any line reaches 3.

**Algorithm:**
1. Assign +1 to A, -1 to B.
2. Track sum for 3 rows, 3 cols, 2 diagonals.
3. Win when |sum| == 3.

**Complexity:**

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |
