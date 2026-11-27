# 1599. Maximum Profit of Operating a Centennial Wheel — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-profit-of-operating-a-centennial-wheel/

---

## Solution: Simulation — O(n) time, O(1) space

**Idea:** Simulate each rotation, tracking waiting customers, cumulative profit, and the best rotation seen so far. Continue until all customers have boarded.

**Algorithm:**
1. For each rotation: add arriving customers to `waiting`, board `min(4, waiting)`, decrement `waiting`.
2. Update `profit += boarded * boardingCost - runningCost`.
3. If `profit > maxProfit`, update `maxProfit` and `bestRound`.
4. After all `customers` arrivals, continue rotating while `waiting > 0`.
5. Return `bestRound` (-1 if never profitable).

**Complexity:**

| | |
|---|---|
| Time | O(n + waiting/4) — n customer batches plus extra rotations for queue |
| Space | O(1) — constant extra space |
