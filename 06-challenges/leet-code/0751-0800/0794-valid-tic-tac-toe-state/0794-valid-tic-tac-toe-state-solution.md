# 794. Valid Tic-Tac-Toe State — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/valid-tic-tac-toe-state/

---

## Solution: Case Analysis — O(1) time, O(1) space

**Idea:** Count X's and O's. Valid iff: (1) countX == countO or countX == countO+1; (2) if X wins, countX == countO+1; (3) if O wins, countX == countO; (4) both cannot win simultaneously.

**Algorithm:**
1. Count X's and O's; return false if countO > countX or countX > countO+1.
2. Check wins for X and O.
3. If X wins: must have countX == countO+1.
4. If O wins: must have countX == countO.
5. Both winning simultaneously is impossible.

**Complexity:**

| | |
|---|---|
| Time | O(1) — fixed 3×3 board |
| Space | O(1) |
