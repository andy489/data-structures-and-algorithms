# 223. Rectangle Area — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/rectangle-area/

---

## Solution: Area Formula — O(1) time, O(1) space

**Idea:** Total area = area(A) + area(B) - overlap area. The overlap rectangle's x-range is `[max(ax1,bx1), min(ax2,bx2)]` and y-range is `[max(ay1,by1), min(ay2,by2)]`. If either range is non-positive, there's no overlap.

**Algorithm:**
1. Compute `areaA = (ax2 - ax1) * (ay2 - ay1)`.
2. Compute `areaB = (bx2 - bx1) * (by2 - by1)`.
3. `overlapW = max(0, min(ax2, bx2) - max(ax1, bx1))`.
4. `overlapH = max(0, min(ay2, by2) - max(ay1, by1))`.
5. Return `areaA + areaB - overlapW * overlapH`.

**Complexity:**

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |
