# 155. Min Stack — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/min-stack/

---

## Solution 1: Auxiliary Min Stack — O(1) all ops, O(n) space

**Idea:** Maintain a second stack `minStack` in parallel. Each `push` also pushes `min(val, minStack.top())` onto `minStack`. Each `pop` also pops `minStack`. `getMin()` just peeks `minStack`.

**Algorithm:**
- `push(val)`: push `val` to main stack; push `min(val, minStack.top())` to min stack.
- `pop()`: pop both stacks.
- `top()`: peek main stack.
- `getMin()`: peek min stack.

**Complexity:**

| | |
|---|---|
| Time | O(1) all operations |
| Space | O(n) — two stacks |

---

## Solution 2: Single Stack of (val, currentMin) Pairs — O(1) all ops, O(n) space

**Idea:** Store each entry as a pair `(value, minSoFar)` in a single stack. `getMin()` returns the second element of the top pair.

**Complexity:**

| | |
|---|---|
| Time | O(1) all operations |
| Space | O(n) — one stack of pairs |
