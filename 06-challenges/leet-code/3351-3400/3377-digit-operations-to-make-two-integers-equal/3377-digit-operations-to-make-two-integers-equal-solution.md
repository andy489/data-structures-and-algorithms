# 3377. Digit Operations to Make Two Integers Equal — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/digit-operations-to-make-two-integers-equal/

---

## Solution: Dijkstra's Algorithm — O(D * 10^D * log(10^D)) time, O(10^D) space

**Idea:** Model the problem as a shortest-path problem. Each non-prime integer is a node. From each node we can reach adjacent integers that differ by 1 in exactly one digit position (and are themselves non-prime). We want the minimum-cost path from `n` to `m`, where cost is the sum of all visited node values (including `n`). If `n` or `m` is prime, return -1 immediately.

Use Dijkstra's algorithm with the cumulative sum as the edge weight: moving from state `curr` to state `next` costs `next` added to the running total.

**Algorithm:**
1. Precompute a sieve of primes up to `10^4`.
2. If `n` or `m` is prime, return -1.
3. Run Dijkstra from `n` with initial cost `n` (we always pay for the starting value).
4. For each current number, generate neighbors by incrementing or decrementing each digit by 1 (keeping digit count the same — no leading zeros).
5. Skip any neighbor that is prime.
6. When `m` is dequeued (or its distance is finalized), return its distance.
7. If `m` is never reached, return -1.

**Complexity:**

| | |
|---|---|
| Time | O(D · 10^D · log(10^D)) — D digits, at most 10^D states, each with D neighbors |
| Space | O(10^D) — distance array and priority queue |
