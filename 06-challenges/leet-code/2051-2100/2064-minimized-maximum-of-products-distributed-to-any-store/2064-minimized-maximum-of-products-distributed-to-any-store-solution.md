# 2064. Minimized Maximum of Products Distributed to Any Store — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/

---

## Solution: Binary Search on Answer — O(m log maxQ) time, O(1) space

**Idea:** Binary search on the max. For a given max x, minimum stores needed = sum of ceil(q/x). Check <= n.

**Algorithm:**
1. Binary search on answer x in [1, max(quantities)].
2. For each x, compute sum(ceil(q/x)); if <= n, x is feasible.
3. Return minimum feasible x.

**Complexity:**

| | |
|---|---|
| Time | O(m log maxQ) |
| Space | O(1) |
