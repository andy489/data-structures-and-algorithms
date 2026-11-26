# 309. Best Time to Buy and Sell Stock with Cooldown — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

---

## Solution: State Machine DP — O(n) time, O(1) space

**Idea:** Three states: `held` (holding stock), `sold` (just sold — next is cooldown), `rest` (cooldown or idle). Transitions: `held' = max(held, rest-price)`, `sold' = held+price`, `rest' = max(rest, sold)`.

**Algorithm:**
1. Init `held = -prices[0]`, `sold = rest = 0`.
2. For each price from day 1: update states simultaneously.
3. Return `max(sold, rest)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
