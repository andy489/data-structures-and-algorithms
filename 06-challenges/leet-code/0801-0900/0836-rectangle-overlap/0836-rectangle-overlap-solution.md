# 836. Rectangle Overlap — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/rectangle-overlap/

---

## Solution: Interval Intersection — O(1) time, O(1) space

**Idea:** Two rectangles overlap iff their projections on both axes overlap. Projections overlap when max(left1, left2) < min(right1, right2).

**Algorithm:**
1. Check x-overlap: max(rec1[0], rec2[0]) < min(rec1[2], rec2[2])
2. Check y-overlap: max(rec1[1], rec2[1]) < min(rec1[3], rec2[3])
3. Return both are true.

**Complexity:**

| | |
|---|---|
| Time | O(1) — constant comparisons |
| Space | O(1) — no extra space |
