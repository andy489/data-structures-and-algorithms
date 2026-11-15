# 122. Best Time to Buy and Sell Stock II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

---

## Solution: Greedy — Collect Every Upslope — O(n) time, O(1) space

**Idea:** Because we can buy and sell on the same day, any profit from a multi-day upward run equals the sum of all daily gains within that run. It is never worse to collect every positive difference `prices[i] - prices[i-1]`. Negative differences are simply ignored (we would not have been holding on those days). This is equivalent to summing all positive increments in the price array.

**Algorithm:**
1. Initialize `profit = 0`.
2. For `i` from `1` to `n-1`:
   - If `prices[i] > prices[i-1]`, add `prices[i] - prices[i-1]` to `profit`.
3. Return `profit`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — one variable |

---

## Solution 2: Peak-Valley — O(n) time, O(1) space

**Idea:** Explicitly find each valley (local minimum) and the next peak (local maximum) after it, then accumulate `peak - valley`. Captures the same profit as the greedy sum but makes the buy/sell points explicit.

**Algorithm:**
1. Initialize `profit = 0`, `i = 0`.
2. While `i < n - 1`:
   - Advance `i` while `prices[i] >= prices[i+1]` (find valley).
   - Record `valley = prices[i]`.
   - Advance `i` while `i < n-1` and `prices[i] <= prices[i+1]` (find peak).
   - Add `prices[i] - valley` to `profit`.
3. Return `profit`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — a few variables |
