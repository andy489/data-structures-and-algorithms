# 812. Largest Triangle Area — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/largest-triangle-area/

---

## Solution: Brute Force with Shoelace Formula — O(n³) time, O(1) space

**Idea:** Try all triples of points and compute area using the shoelace formula. Take the maximum.

**Algorithm:**
1. For each triple (A, B, C), compute area = |Ax(By−Cy) + Bx(Cy−Ay) + Cx(Ay−By)| / 2.
2. Track maximum area.

**Complexity:**

| | |
|---|---|
| Time | O(n³) — n ≤ 50, so at most 19600 triples |
| Space | O(1) — constant extra space |
