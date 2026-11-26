# 874. Walking Robot Simulation — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/walking-robot-simulation/

---

## Solution: Simulation with HashSet — O(n + m) time, O(m) space

**Idea:** Simulate the robot's movement. Use a set for fast obstacle lookup. Track direction with index into 4 directions.

**Algorithm:**
1. Put obstacles in a set of encoded strings "x,y".
2. Directions: N(0,1), E(1,0), S(0,-1), W(-1,0). Start facing N (index 0).
3. For each command: turn or walk step-by-step, stopping before obstacles.
4. Track max x^2 + y^2.

**Complexity:**

| | |
|---|---|
| Time | O(n * k + m) — n commands, k max steps, m obstacles |
| Space | O(m) |
