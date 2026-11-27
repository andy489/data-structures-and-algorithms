# 121. Best Time to Buy and Sell Stock — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

---

## Solution: One-Pass Min-Tracking — O(n) time, O(1) space

**Idea:** The maximum profit on any day `i` equals `prices[i] - minPriceSoFar`. Scan left to right: keep a running minimum of prices seen so far, and update the best profit each time a higher selling price is encountered.

**Algorithm:**
1. Initialize `minPrice = Integer.MAX_VALUE`, `maxProfit = 0`.
2. For each `price` in `prices`:
   - Update `minPrice = min(minPrice, price)`.
   - Update `maxProfit = max(maxProfit, price - minPrice)`.
3. Return `maxProfit`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — two variables |

---

## Solution 2: Kadane's Algorithm (Max Subarray on Differences) — O(n) time, O(1) space

**Idea:** Build the daily difference array `diff[i] = prices[i] - prices[i-1]`. The maximum profit from buying on day `i` and selling on day `j` equals the maximum subarray sum of `diff[i+1..j]`. Apply Kadane's algorithm on the difference array directly without materialising it.

**Algorithm:**
1. Initialize `currentGain = 0`, `maxProfit = 0`.
2. For `i` from `1` to `n-1`:
   - `currentGain = max(0, currentGain + prices[i] - prices[i-1])`.
   - `maxProfit = max(maxProfit, currentGain)`.
3. Return `maxProfit`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — two variables |
