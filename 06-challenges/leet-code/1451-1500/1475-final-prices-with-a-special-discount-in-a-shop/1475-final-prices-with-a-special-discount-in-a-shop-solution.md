# 1475. Final Prices With A Special Discount In A Shop — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/

---

## Solution: Monotonic Stack — O(n) time, O(n) space

**Idea:** Use a monotonic decreasing stack. When a smaller price is found, pop and apply discount.

**Algorithm:**
1. Maintain a stack of indices with decreasing prices.
2. For each i: while stack not empty and prices[i] <= prices[stack.top]: pop, apply discount.
3. Push i.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
