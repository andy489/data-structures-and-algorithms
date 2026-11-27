# 1041. Robot Bounded In Circle

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/robot-bounded-in-circle/

---

## Problem Statement

On an infinite plane, a robot initially stands at `(0, 0)` and faces north. Note that:
- The north direction is the positive direction of the y-axis.
- The south direction is the negative direction of the y-axis.
- The east direction is the positive direction of the x-axis.
- The west direction is the negative direction of the x-axis.

The robot can receive one of three instructions: `'G'` (go straight 1 unit), `'L'` (turn 90 degrees to the left), `'R'` (turn 90 degrees to the right).

The robot performs the `instructions` given in order, and repeats them forever. Return `true` if and only if there exists a circle in the plane such that the robot never leaves the circle.

---

## Examples

**Example 1:**
```
Input:  instructions = "GGLLGG"
Output: true
```

**Example 2:**
```
Input:  instructions = "GG"
Output: false
```

---

## Constraints

- `1 <= instructions.length <= 100`
- `instructions[i]` is `'G'`, `'L'` or `'R'`.
