# 950. Reveal Cards In Increasing Order — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/reveal-cards-in-increasing-order/

---

## Solution: Simulate with Queue — O(n log n) time, O(n) space

**Idea:** Simulate the reveal process with indices. Sort deck. Use a queue of indices 0..n-1; repeatedly assign the next sorted card to index queue.popleft(), then move queue.popleft() to the back (simulating the skip).

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
