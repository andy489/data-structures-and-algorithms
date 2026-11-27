# 1801. Number of Orders in the Backlog — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-orders-in-the-backlog/

---

## Solution: Two Heaps — O(n log n) time, O(n) space

**Idea:** Maintain a max-heap for buy orders (highest price first) and a min-heap for sell orders (lowest price first). For each incoming buy order, greedily match it against the cheapest available sell orders; for each incoming sell order, match it against the most expensive available buy orders. Whatever remains unmatched goes into the respective backlog heap.

**Algorithm:**
1. Initialize `buy` as a max-heap and `sell` as a min-heap.
2. For each order `[price, amount, type]`:
   - If `type == 0` (buy): while `amount > 0` and sell heap is non-empty and `sell.peek().price <= price`, pop the cheapest sell, compute matched quantity, push back any remainder.
   - If `type == 1` (sell): while `amount > 0` and buy heap is non-empty and `buy.peek().price >= price`, pop the most expensive buy, compute matched quantity, push back any remainder.
   - If any `amount` remains, push it onto the appropriate heap.
3. Sum all remaining amounts across both heaps, return modulo `10^9 + 7`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — each order triggers at most O(log n) heap operations |
| Space | O(n) — heaps hold at most n entries total |
