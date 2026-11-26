# 1232. Check If It Is a Straight Line — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/check-if-it-is-a-straight-line/

---

## Solution: Cross Product — O(n) time, O(1) space

**Idea:** Use cross product to avoid division. For three points A, B, C: they're collinear iff (B-A) × (C-A) = 0.

**Algorithm:**
1. Compute dx = x1-x0, dy = y1-y0.
2. For each subsequent point (xi, yi): check (xi-x0)*dy == (yi-y0)*dx.
3. Return false on mismatch.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
