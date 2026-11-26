# 3001. Minimum Moves To Capture The Queen — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-moves-to-capture-the-queen/

---

## Solution: Case Analysis — O(1) time, O(1) space

**Idea:** The rook can reach any position in at most 2 moves (move row then column). The bishop can reach any diagonal position in 1 move if on the same diagonal. Check if either piece can capture in 1 move; if rook can capture in 1 move (same row/col and not blocked by bishop), or bishop can capture in 1 move (same diagonal and not blocked by rook), return 1; otherwise return 2.

**Algorithm:**
1. Check if rook shares row or column with queen:
2.   If same row: check if bishop is between them on that row → 2 moves, else 1.
3.   If same col: check if bishop is between them on that col → 2 moves, else 1.
4. Check if bishop shares diagonal with queen:
5.   If same diagonal: check if rook is between them → 2 moves, else 1.
6. Otherwise return 2.

**Complexity:**

| | |
|---|---|
| Time | O(1) — O(1) — fixed board |
| Space | O(1) — O(1) |
