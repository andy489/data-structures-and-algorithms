# 901. Online Stock Span — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/online-stock-span/

---

## Solution: Monotonic Stack — O(1) amortized time, O(n) space

**Idea:** Use a stack storing `(price, span)` pairs. For each new price, pop all stack entries with price ≤ current price, accumulating their spans. Push the new entry with the total span.

**Algorithm:**
1. Initialize stack.
2. For each `next(price)`: set span = 1.
3. While stack non-empty and stack top price ≤ price: span += stack.pop().span.
4. Push `(price, span)`. Return span.

**Complexity:**

| | |
|---|---|
| Time | O(1) amortized — each element pushed/popped once |
| Space | O(n) — stack size |
