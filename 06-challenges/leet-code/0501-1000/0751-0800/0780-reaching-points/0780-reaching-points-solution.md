# 780. Reaching Points — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/reaching-points/

---

## Solution: Reverse Reduction — O(log(max(tx,ty))) time, O(1) space

**Idea:** Work backwards from `(tx, ty)`. The predecessor of `(tx, ty)` is either `(tx-ty, ty)` (if tx > ty) or `(tx, ty-tx)`. Use modulo to skip many steps at once.

**Algorithm:**
1. While `tx >= sx` and `ty >= sy`:
   - If `tx == sx`: return `(ty - sy) % sx == 0`.
   - If `ty == sy`: return `(tx - sx) % sy == 0`.
   - If `tx > ty`: `tx %= ty`.
   - Else: `ty %= tx`.
2. Return false.

**Complexity:**

| | |
|---|---|
| Time | O(log(max(tx,ty))) — Euclidean-like reduction |
| Space | O(1) |
