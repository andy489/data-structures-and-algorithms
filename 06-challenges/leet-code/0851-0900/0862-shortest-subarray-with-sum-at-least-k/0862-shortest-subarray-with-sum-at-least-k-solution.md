# 862. Shortest Subarray with Sum at Least K — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/

---

## Solution: Prefix Sum + Monotonic Deque — O(n) time, O(n) space

**Idea:** Compute prefix sums. For subarrays with negative numbers, use a monotone deque to efficiently find the shortest subarray with sum ≥ k. Maintain a deque of increasing prefix sum indices.

**Algorithm:**
1. Compute prefix sums P[0..n].
2. Maintain deque of indices in increasing order of P values.
3. For each i, while deque front j has P[i] - P[j] >= k: update ans, pop front.
4. While deque back j has P[j] >= P[i]: pop back (can't be useful later).
5. Push i.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each index pushed/popped once |
| Space | O(n) — prefix sums + deque |
