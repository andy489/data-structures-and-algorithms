# 714. Best Time to Buy and Sell Stock with Transaction Fee — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

---

## Solution: DP (Greedy with States) — O(n) time, O(1) space

**Idea:** Track two states: `hold` (max profit holding stock) and `free` (max profit not holding stock). At each day, update both states.

**Algorithm:**
1. Init: `hold = -prices[0]`, `free = 0`.
2. For each price: `newHold = max(hold, free - price)`, `newFree = max(free, hold + price - fee)`.
3. Return `free`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
