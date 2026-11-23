# 289. Game of Life — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/game-of-life/

---

## Solution: In-Place with Encoded States — O(m·n) time, O(1) space

**Idea:** Use extra bit values to encode transitions in-place without extra space:
- `2`: was live, now dead (live → dead)
- `3`: was dead, now live (dead → live)

After marking all transitions, a second pass converts: values `>= 2` with original alive (odd values, i.e., `1` and `3`) → 1 or 0.

More precisely: encode `1→0` as `-1` and `0→1` as `2`. Count neighbors by checking `abs(neighbor) == 1`. Final pass: `-1 → 0`, `2 → 1`.

**Algorithm:**
1. For each cell, count live neighbors (original state: `board[r][c] == 1` or `== -1`).
2. Apply rules: live cell with < 2 or > 3 live neighbors → mark `-1`; dead cell with exactly 3 live neighbors → mark `2`.
3. Final pass: `-1 → 0`, `2 → 1`.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — two passes over the grid |
| Space | O(1) — encoding done in-place |
