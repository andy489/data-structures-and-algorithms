# 225. Implement Stack using Queues — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/implement-stack-using-queues/

---

## Solution: Single Queue — O(n) push, O(1) pop/top/empty

**Idea:** Use one queue. On `push(x)`, enqueue `x`, then rotate all elements before it to the back so `x` is at the front. This makes every subsequent `pop` and `top` O(1).

**Algorithm:**
1. `push(x)`: `queue.offer(x)`; rotate `queue.size() - 1` times: `queue.offer(queue.poll())`.
2. `pop()`: `queue.poll()`.
3. `top()`: `queue.peek()`.
4. `empty()`: `queue.isEmpty()`.

**Complexity:**

| | |
|---|---|
| Time | O(n) push, O(1) pop/top/empty |
| Space | O(n) |
