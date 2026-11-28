# 2943. Maximize Area of Square Hole in Grid — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximize-area-of-square-hole-in-grid/

---

## Solution: Max Consecutive Run — O(h log h + v log v) time, O(1) extra space

**Idea:** The side length of the largest square hole equals min(maxConsecutiveH, maxConsecutiveV) + 1, where "consecutive" means bars with consecutive indices all present in the removable set (so they can all be removed to form one large gap).

Sort both arrays. Find the maximum run of consecutive integers in each. The gap created by removing `r` consecutive bars is `r + 1` cells wide. Take the minimum of the two maximums and square it.

**Algorithm:**
1. Sort `hBars` and `vBars`.
2. Find maxRun for each: iterate, counting consecutive elements (diff == 1).
3. Answer = min(maxRunH, maxRunV) + 1, squared.

**Complexity:**

| | |
|---|---|
| Time | O(h log h + v log v) |
| Space | O(1) extra |
