# 519. Random Flip Matrix — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/random-flip-matrix/

---

## Solution: Fisher-Yates with HashMap — O(1) per flip, O(flips) space

**Idea:** Treat the m×n matrix as a flat array of size `total = m*n`. Maintain a counter `remaining` of unflipped cells. On each `flip()`, pick a random index `r` in `[0, remaining)`, swap it with the cell at index `remaining-1` using a HashMap (virtual swap: if position r is remapped, use the mapped value; else use r itself), then decrement `remaining`. Convert flat index to `(i, j)` as `(r / n, r % n)`.

**Complexity:**

| | |
|---|---|
| Time | O(1) per flip/reset (expected) |
| Space | O(number of flips) for the HashMap |
