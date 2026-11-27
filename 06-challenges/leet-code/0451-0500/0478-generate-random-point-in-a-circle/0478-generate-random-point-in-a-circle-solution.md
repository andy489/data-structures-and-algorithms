# 478. Generate Random Point in a Circle — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/generate-random-point-in-a-circle/

---

## Solution: Polar Coordinates (Square Root Sampling) — O(1) time, O(1) space

**Idea:** To get uniform distribution over a disk, we can't just use uniform angle + uniform radius (that biases toward center). Instead: pick `r = radius * sqrt(rand())` to correct the density. Angle is uniform in [0, 2π).

**Algorithm:**
1. `angle = 2 * PI * Math.random()`.
2. `r = radius * Math.sqrt(Math.random())`.
3. Return `[x_center + r * cos(angle), y_center + r * sin(angle)]`.

**Complexity:**

| | |
|---|---|
| Time | O(1) per call |
| Space | O(1) |
