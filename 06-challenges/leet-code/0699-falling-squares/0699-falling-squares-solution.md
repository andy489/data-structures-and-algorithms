# 699. Falling Squares — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/falling-squares/

---

## Solution: Brute Force Interval Check — O(n²) time, O(n) space

**Idea:** For each square, check all previously placed squares to find the maximum height it can land on. Track the intervals and their settled heights.

**Algorithm:**
1. Maintain a list of `(left, right, height)` for placed squares.
2. For each new square `[l, side]`: `r = l + side`. Find max height among intervals that overlap with `[l, r)` (not touching).
3. New square height = max_overlap + side. Track global max.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — check all prior squares for each new one |
| Space | O(n) |
