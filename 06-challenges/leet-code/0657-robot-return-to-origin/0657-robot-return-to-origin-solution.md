# 657. Robot Return to Origin — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/robot-return-to-origin/

---

## Solution: Count Moves — O(n) time, O(1) space

**Idea:** Count L/R and U/D moves separately. The robot returns to origin iff L==R and U==D.

**Algorithm:**
1. Track `x` and `y` offsets.
2. Increment/decrement based on direction.
3. Return `x == 0 && y == 0`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass through moves |
| Space | O(1) |
