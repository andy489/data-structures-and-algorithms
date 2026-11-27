# 735. Asteroid Collision — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/asteroid-collision/

---

## Solution: Stack — O(n) time, O(n) space

**Idea:** Use a stack. For each asteroid: if it's positive or the stack is empty or the top is negative (no collision), push it. Otherwise (negative asteroid meeting positive top), simulate the collision: if top is smaller it explodes (pop), if equal both explode (pop and discard new), if top is larger the new one explodes (discard new).

**Algorithm:**
1. For each `a` in `asteroids`:
   - While stack not empty, stack top > 0, and `a < 0` (collision):
     - If `stack.top < -a`: pop (top explodes), continue loop.
     - If `stack.top == -a`: pop (both explode), mark `a` as destroyed, break.
     - If `stack.top > -a`: mark `a` as destroyed, break.
   - If `a` not destroyed, push.
2. Return stack as array.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each asteroid pushed/popped at most once |
| Space | O(n) — stack |
