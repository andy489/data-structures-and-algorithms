# 84. Largest Rectangle in Histogram — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/largest-rectangle-in-histogram/

---

## Solution: Monotonic Stack — O(n) time, O(n) space

**Idea:** Maintain a stack of indices in increasing order of height. When a bar shorter than the top of the stack is encountered, the top bar can no longer extend to the right — pop it and compute the rectangle it forms. The width is determined by the distance to the new stack top (or the full range if the stack is empty). After processing all bars, pop remaining elements similarly using `n` as the right boundary.

**Algorithm:**
1. Push a sentinel `-1` onto the stack.
2. For each index `i` from `0` to `n`:
   - Use `h = (i == n) ? 0 : heights[i]` to flush the stack at the end.
   - While `stack.top() != -1` and `heights[stack.top()] >= h`:
     - Pop index `top`; width = `i - stack.top() - 1`; update `maxArea`.
   - Push `i`.
3. Return `maxArea`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each index pushed and popped at most once |
| Space | O(n) — stack |
