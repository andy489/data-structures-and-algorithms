# 874. Walking Robot Simulation

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/walking-robot-simulation/

---

## Problem Statement

A robot on an infinite XY-plane starts at position `(0, 0)` facing north. It can receive an array of instructions `commands`:
- `-2`: turn left 90 degrees
- `-1`: turn right 90 degrees
- `1 <= k <= 9`: walk forward `k` steps

There are `obstacles` on the plane: `obstacles[i] = [xi, yi]`. If the robot walks into an obstacle, it stops at the cell before the obstacle.

Return the maximum Euclidean distance squared (x^2 + y^2) that the robot can reach at any point.

---

## Examples

**Example 1:**
```
Input:  commands = [4,-1,3], obstacles = []
Output: 25
```

**Example 2:**
```
Input:  commands = [4,-1,4,-2,4], obstacles = [[2,4]]
Output: 65
```

---

## Constraints

- `1 <= commands.length <= 10^4`
- `commands[i]` is either `-2`, `-1`, or an integer in the range `[1, 9]`.
- `0 <= obstacles.length <= 10^4`
- `-3 * 10^4 <= xi, yi <= 3 * 10^4`
