# 390. Elimination Game — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/elimination-game/

---

## Solution: Track Head — O(log n) time, O(1) space

**Idea:** Track the current leftmost value `head`. On a left-to-right pass, `head` always moves right by `step`. On a right-to-left pass, `head` moves right by `step` only when the remaining count is odd.

**Algorithm:**
1. `head = 1, step = 1, remaining = n, left = true`.
2. Each round: if `left` or `remaining` is odd, `head += step`. Halve `remaining`, double `step`, flip `left`.
3. Return `head` when `remaining == 1`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) |
| Space | O(1) |
