# 1041. Robot Bounded In Circle — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/robot-bounded-in-circle/

---

## Solution: Simulate One Pass — O(n) time, O(1) space

**Idea:** After one pass of instructions, the robot is bounded iff it's back at origin OR it's not facing north (then repeating will cycle).

**Algorithm:**
1. Simulate the instructions tracking position and direction.
2. After one cycle: return true if at origin, or not facing north.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
