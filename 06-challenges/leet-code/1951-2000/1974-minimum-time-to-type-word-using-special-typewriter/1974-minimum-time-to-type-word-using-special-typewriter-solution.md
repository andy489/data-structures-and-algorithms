# 1974. Minimum Time to Type Word Using Special Typewriter — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/

---

## Solution: Greedy — O(n) time, O(1) space

**Idea:** For each character transition, take the minimum of clockwise and counterclockwise distance on the circle of 26 letters. Each character also costs 1 second to type.

**Algorithm:**
1. Start from `'a'` (position 0).
2. For each character in `word`, compute `diff = abs(cur - next)` where positions are `0..25`.
3. Add `min(diff, 26 - diff) + 1` (move + type).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
