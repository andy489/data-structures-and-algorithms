# 1776. Car Fleet II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/car-fleet-ii/

---

## Solution: Monotonic Stack (Right to Left) — O(n) time, O(n) space

**Idea:** Process cars from right to left. Maintain a monotonic stack of cars that are "reachable" candidates. For car `i`, compute when it would catch each car on the stack. If car `i` would catch stack-top car `j` before car `j` catches its next car (fleet), that's the collision time. Otherwise, pop `j` (car `i` will never catch `j` before `j` merges into a faster fleet ahead).

**Algorithm:**
1. Process from right to left. Maintain stack of indices (candidates for collision with car `i`).
2. For car `i` with speed `si`, position `pi`:
   - Pop stack top `j` if `sj >= si` (car `i` can never catch a slower-or-equal car ahead) — actually we pop if car `i` doesn't catch `j` before `j` merges.
   - Specifically: collision time with `j` is `t = (pos[j] - pos[i]) / (speed[i] - speed[j])`. If `answer[j] != -1` and `t >= answer[j]`, then car `i` won't directly hit `j`; pop and try next.
   - If stack is empty after popping, `answer[i] = -1`; otherwise `answer[i] = t`.
3. Push car `i` onto the stack.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each car is pushed and popped at most once |
| Space | O(n) — stack |
