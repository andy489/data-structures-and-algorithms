# 1144. Decrease Elements To Make Array Zigzag — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/decrease-elements-to-make-array-zigzag/

---

## Solution: Greedy — O(n) time, O(1) space

**Idea:** There are exactly two target patterns: "small at even indices" or "small at odd indices". We can only decrease values, never increase. To make index `i` a local minimum, we need all neighbors of `i` to be strictly greater than `nums[i]`. The cheapest way is to decrease `nums[i]` to `min(neighbors) - 1` if it isn't already less. We compute the cost for both patterns independently and return the minimum.

**Algorithm:**
1. For parity `p` in `{0, 1}` (the parity of indices that should be local minima):
   - For each index `i` with `i % 2 == p`:
     - Find the minimum neighbor value `minNeighbor`.
     - If `nums[i] >= minNeighbor`, cost += `nums[i] - minNeighbor + 1`.
2. Return `min(cost[0], cost[1])`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two passes |
| Space | O(1) |
