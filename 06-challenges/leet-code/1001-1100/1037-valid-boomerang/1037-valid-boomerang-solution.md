# 1037. Valid Boomerang — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/valid-boomerang/

---

## Solution: Cross Product — O(1) time, O(1) space

**Idea:** Three points are collinear iff the cross product of vectors AB and AC is 0.

**Algorithm:**
1. Compute vectors AB = (x1-x0, y1-y0) and AC = (x2-x0, y2-y0).
2. Cross product = AB.x * AC.y - AB.y * AC.x.
3. Return `cross != 0`.

**Complexity:**

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |
