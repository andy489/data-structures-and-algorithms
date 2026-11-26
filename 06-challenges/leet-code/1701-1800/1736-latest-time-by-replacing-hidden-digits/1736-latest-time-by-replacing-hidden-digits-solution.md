# 1736. Latest Time by Replacing Hidden Digits — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/

---

## Solution: Greedy Rule per Position — O(1) time, O(1) space

**Idea:** Each `?` position has a fixed set of valid digits. Greedily pick the largest digit for each position subject to the constraints from the adjacent known digit.

**Rules:**
- `h1` (index 0): if `h2 <= 3` pick `2`, else pick `1`, but if `h2` is `?` pick `2`.
- `h2` (index 1): if `h1 == 2` pick `3`, else pick `9`.
- `m1` (index 3): pick `5`.
- `m2` (index 4): pick `9`.

**Complexity:**

| | |
|---|---|
| Time | O(1) — constant work |
| Space | O(1) — single char array |
