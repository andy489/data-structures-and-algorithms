# 1465. Maximum Area Of A Piece Of Cake After Horizontal And Vertical Cuts — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/

---

## Solution: Sort + Max Gap — O(n log n) time, O(1) space

**Idea:** Sort cuts. Find max gap between consecutive cuts (including boundary) horizontally and vertically. Area = maxH * maxW.

**Algorithm:**
1. Sort horizontalCuts and verticalCuts.
2. Find max horizontal gap: max(h[0]-0, gaps, h-h[-1]).
3. Find max vertical gap similarly.
4. Return (maxH * maxW) % MOD.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(1) |
