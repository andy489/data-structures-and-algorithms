# 818. Race Car

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/race-car/

---

## Problem Statement

Your car starts at position 0 and speed +1 on an infinite number line. The car can go into negative positions. The car drives automatically according to a sequence of instructions `'A'` (accelerate) or `'R'` (reverse).

- `A`: position += speed, speed *= 2
- `R`: speed = (speed > 0) ? -1 : 1

Return the length of the shortest sequence of instructions to reach the target position.

---

## Examples

**Example 1:**
```
Input:  target = 3
Output: 2
Explanation: "AA": position = 1 -> 3
```

**Example 2:**
```
Input:  target = 6
Output: 5
```

---

## Constraints

- `1 <= target <= 10^4`
