# 42. Trapping Rain Water — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/trapping-rain-water/

---

## Solution: Two pointers — O(n) time, O(1) space

**Idea:** Water at position `i` is bounded by `min(maxLeft, maxRight) - height[i]`. Use two pointers `l` and `r` converging inward. Maintain `maxL` and `maxR` as the running maximums from each side. At each step, process the side with the smaller max — its water level is fully determined (the taller side can only be taller or equal on the other pointer's side).

**Algorithm:**
1. `l = 0`, `r = n-1`, `maxL = maxR = 0`, `water = 0`.
2. While `l < r`:
   - If `maxL <= maxR`: water `+= maxL - height[l]` (or 0 if negative isn't possible since maxL ≥ height[l]). Update `maxL = max(maxL, height[l])`. Advance `l++`.
   - Else: symmetrically process right side. Update `maxR`, advance `r--`.
3. Return `water`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass with two pointers |
| Space | O(1) — only four variables |

---

## Solution 2: Precomputed prefix/suffix max arrays — O(n) time, O(n) space

**Idea:** Precompute `leftMax[i]` = max height from `0..i` and `rightMax[i]` = max height from `i..n-1`. Water at `i` = `min(leftMax[i], rightMax[i]) - height[i]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — three linear passes |
| Space | O(n) — two auxiliary arrays |
