# 3380. Maximum Area Rectangle With Point Constraints I — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-area-rectangle-with-point-constraints-i/

---

## Solution: Brute Force with Point Check — O(n^4 * n) time, O(n) space

**Idea:** With `n <= 10`, we can try all combinations of 4 points and check if they form an axis-aligned rectangle with no other points on its border or interior. For each valid rectangle, track the maximum area.

**Algorithm:**
1. Put all points in a set for O(1) lookup.
2. Try every pair of points `(p1, p2)` as diagonal corners: they define an axis-aligned rectangle when their x-coordinates and y-coordinates both differ.
3. Check that the other two corners `(x1,y2)` and `(x2,y1)` both exist in the point set.
4. For each such rectangle, verify no other point lies strictly inside or on its border.
5. Track the maximum area `(x2-x1) * (y2-y1)`.

**Complexity:**

| | |
|---|---|
| Time | O(n^2 * n) — O(n^2) rectangle candidates, O(n) check per candidate |
| Space | O(n) — point set |
