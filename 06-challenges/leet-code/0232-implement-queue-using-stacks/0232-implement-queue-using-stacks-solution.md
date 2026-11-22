# 232. Implement Queue using Stacks — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/implement-queue-using-stacks/

---

## Solution: Two Stacks, Lazy Transfer — Amortized O(1) per operation

**Idea:** Use `inbox` for pushes and `outbox` for pops/peeks. When `outbox` is empty and a pop/peek is needed, pour all of `inbox` into `outbox`. Each element moves at most once, so operations are amortised O(1).

**Algorithm:**
1. `push(x)`: push onto `inbox`.
2. `pop()`: if `outbox` empty, transfer all from `inbox`; then `outbox.pop()`.
3. `peek()`: same transfer; then `outbox.peek()`.
4. `empty()`: both stacks empty.

**Complexity:**

| | |
|---|---|
| Time | Amortized O(1) per operation |
| Space | O(n) |
