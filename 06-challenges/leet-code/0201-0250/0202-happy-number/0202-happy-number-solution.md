# 202. Happy Number — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/happy-number/

---

## Solution: Floyd's cycle detection (fast & slow pointers) — O(log n) time, O(1) space

**Idea:** The digit-square sequence either terminates at 1 or enters a cycle. Treat the sequence as a linked list and apply Floyd's tortoise-and-hare algorithm. The slow pointer advances one step; the fast pointer advances two. If they ever meet at 1, the number is happy. If they meet anywhere else, a cycle exists and the number is not happy.

**Algorithm:**
1. Define `next(x)`: compute the sum of squares of digits of `x`.
2. Set `slow = n`, `fast = next(n)`.
3. While `fast != 1` and `slow != fast`: `slow = next(slow)`, `fast = next(next(fast))`.
4. Return `fast == 1`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — the sequence reaches a single-digit number quickly; cycle detection adds a constant factor |
| Space | O(1) — only two integer variables |

---

## Solution 2: Hash set cycle detection — O(log n) time, O(log n) space

**Idea:** Store each seen value in a set. If we reach 1 → happy; if we see a repeat → cycle → not happy.

**Algorithm:**
1. Initialize an empty set `seen`.
2. While `n != 1` and `n` not in `seen`: add `n` to `seen`, replace `n` with `next(n)`.
3. Return `n == 1`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — same sequence length |
| Space | O(log n) — stores all values until cycle or 1 |
