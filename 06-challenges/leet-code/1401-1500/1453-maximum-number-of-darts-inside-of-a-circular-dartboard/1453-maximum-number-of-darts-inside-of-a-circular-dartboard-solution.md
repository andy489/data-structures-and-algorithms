# 1453. Maximum Number Of Darts Inside Of A Circular Dartboard — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-number-of-darts-inside-of-a-circular-dartboard/

---

## Solution: O(n^3) Geometry — O(n^3) time, O(1) space

**Idea:** For each pair of points, find the (up to 2) circle centers of radius r passing through both. Count how many points are inside each such circle.

**Algorithm:**
1. Try all pairs (i,j). For each pair, compute at most 2 circle centers of radius r passing through them.
2. For each center, count how many darts are within radius r.
3. Also check single-point circles (each dart alone). Return max count.

**Complexity:**

| | |
|---|---|
| Time | O(n^3) |
| Space | O(1) |
