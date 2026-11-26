# 188. Best Time to Buy and Sell Stock IV — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

---

## Solution 1: DP — `buy[j]` / `sell[j]` Rolling Arrays — O(n·k) time, O(k) space

**Idea:** Track two 1-D arrays of length `k`: `buy[j]` = max profit after the j-th buy (not yet sold), `sell[j]` = max profit after the j-th sell. For each price, update from the last transaction backwards to avoid using the same price twice in one transaction.

If `k >= n/2`, any number of transactions is effectively unlimited — handle with a greedy sum of all positive differences.

**Algorithm:**
1. If `k >= n / 2`, return greedy unlimited profit (sum every `prices[i] - prices[i-1] > 0`).
2. Init `buy[0..k-1] = -prices[0]`, `sell[0..k-1] = 0`.
3. For each price `p` from index 1:
   - For each transaction `j` from 0 to `k-1`:
     - `buy[j]  = max(buy[j],  (j == 0 ? 0 : sell[j-1]) - p)`
     - `sell[j] = max(sell[j], buy[j] + p)`
4. Return `sell[k-1]`.

**Complexity:**

| | |
|---|---|
| Time | O(n·k) — two nested loops |
| Space | O(k) — two rolling arrays of size k |

---

## Solution 2: DP Table — O(n·k) time, O(n·k) space

**Idea:** `dp[j][i]` = max profit using at most `j` transactions through day `i`. Recurrence: `dp[j][i] = max(dp[j][i-1], prices[i] + max_{m<i}(dp[j-1][m] - prices[m]))`, with the running max tracked incrementally.

**Complexity:**

| | |
|---|---|
| Time | O(n·k) |
| Space | O(n·k) |
