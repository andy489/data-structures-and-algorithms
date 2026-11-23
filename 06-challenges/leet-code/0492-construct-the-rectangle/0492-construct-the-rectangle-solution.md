# 492. Construct the Rectangle — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/construct-the-rectangle/

---

## Solution: Square Root Search — O(sqrt(area)) time, O(1) space

**Idea:** Start W from sqrt(area) downward. The first W that evenly divides area gives the minimum L-W difference.

**Algorithm:**
1. Start w = floor(sqrt(area)).
2. While area % w != 0, decrement w.
3. Return [area/w, w].

**Complexity:**

| | |
|---|---|
| Time | O(sqrt(area)) — iterate from sqrt down to first divisor |
| Space | O(1) |
