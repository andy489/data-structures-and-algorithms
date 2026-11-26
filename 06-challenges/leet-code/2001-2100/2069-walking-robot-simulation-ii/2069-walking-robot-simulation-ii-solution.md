# 2069. Walking Robot Simulation II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/walking-robot-simulation-ii/

---

## Solution: Simulation with Modular Arithmetic — O(1) per step time, O(1) space

**Idea:** Perimeter = 2*(width+height-2). Take steps mod perimeter, track boundary position.

**Algorithm:**
1. Compute perimeter.
2. On step, advance position along boundary (mod perimeter).
3. Map linear position to (x, y, dir).

**Complexity:**

| | |
|---|---|
| Time | O(1) per step |
| Space | O(1) |
