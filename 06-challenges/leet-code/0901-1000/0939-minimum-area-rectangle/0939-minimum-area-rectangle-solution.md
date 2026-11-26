# 939. Minimum Area Rectangle — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-area-rectangle/

---

## Solution: HashSet + Pair Enumeration — O(n²) time, O(n) space

**Idea:** Store all points in a set. For each pair of points (diagonal corners), check if the other two corners exist. The area = |dx| × |dy|.

**Complexity:**

| | |
|---|---|
| Time | O(n²) |
| Space | O(n) |
