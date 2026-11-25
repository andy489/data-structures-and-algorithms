# 845. Longest Mountain in Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-mountain-in-array/

---

## Solution: Two Pass (up/down arrays) — O(n) time, O(n) space

**Idea:** Precompute `up[i]` = length of increasing run ending at `i`, and `down[i]` = length of decreasing run starting at `i`. A valid mountain at peak `i` has length `up[i] + down[i] + 1` (when both > 0).

**Algorithm:**
1. Scan left to right to build `up[]`.
2. Scan right to left to build `down[]`.
3. For each index where `up[i] > 0 && down[i] > 0`, update answer with `up[i] + down[i] + 1`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two linear passes |
| Space | O(n) — up/down arrays |
