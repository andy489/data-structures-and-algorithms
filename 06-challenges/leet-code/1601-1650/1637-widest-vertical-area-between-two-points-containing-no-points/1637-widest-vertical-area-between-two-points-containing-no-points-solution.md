# 1637. Widest Vertical Area Between Two Points Containing No Points — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/

---

## Solution: Sort X-Coordinates — O(n log n) time, O(n) space

**Idea:** The y-coordinates are irrelevant. Extract all x-coordinates, sort them, and find the maximum gap between consecutive values.

**Algorithm:**
1. Extract the x-coordinate of each point.
2. Sort the x-coordinates.
3. Return the maximum difference between adjacent sorted x-values.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting |
| Space | O(n) — extracted x-array |
