# 1222. Queens That Can Attack the King — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/queens-that-can-attack-the-king/

---

## Solution: 8-Direction Search — O(1) — 8*8 max time, O(1) space

**Idea:** From the king's position, search in all 8 directions. The first queen found in each direction can attack the king.

**Algorithm:**
1. Store queen positions in a set.
2. For each of 8 directions, walk until off-board or queen found.
3. Collect the first queen hit in each direction.

**Complexity:**

| | |
|---|---|
| Time | O(1) — 8*8 max |
| Space | O(1) |
