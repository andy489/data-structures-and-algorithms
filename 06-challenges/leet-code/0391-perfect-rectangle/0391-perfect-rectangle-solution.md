# 391. Perfect Rectangle — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/perfect-rectangle/

---

## Solution: Area + Corner Set — O(n) time, O(n) space

**Idea:** A perfect cover satisfies two conditions:
1. Total area of all rectangles equals area of the bounding box.
2. Every interior corner appears exactly twice (cancels); only the 4 bounding-box corners appear exactly once.

**Algorithm:**
1. Track bounding box corners; sum areas.
2. For each rectangle, toggle each of its 4 corners in a set (add if absent, remove if present).
3. After processing, the set must contain exactly the 4 bounding-box corners, and total area must match.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — corner set |
