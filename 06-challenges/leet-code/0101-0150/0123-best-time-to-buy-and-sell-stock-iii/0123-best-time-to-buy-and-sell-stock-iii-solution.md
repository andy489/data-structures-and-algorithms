# 123. Best Time to Buy and Sell Stock III — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

---

## Solution: Four-State DP — O(n) time, O(1) space

**Idea:** Track the best outcome for each of four ordered states across a single pass:
1. `buy1` — minimum cost to make the first purchase (negate price to treat it as profit).
2. `sell1` — maximum profit after completing the first transaction.
3. `buy2` — maximum profit after making the second purchase (subtract price from `sell1`).
4. `sell2` — maximum profit after completing the second transaction.

At each price, update all four states greedily. Because we may do at most two transactions, and all states move forward in time, this one-pass update is correct.

**Algorithm:**
1. Initialise `buy1 = -prices[0]`, `sell1 = 0`, `buy2 = -prices[0]`, `sell2 = 0`.
2. For each price `p`:
   - `buy1  = max(buy1,  -p)`
   - `sell1 = max(sell1, buy1 + p)`
   - `buy2  = max(buy2,  sell1 - p)`
   - `sell2 = max(sell2, buy2 + p)`
3. Return `sell2`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — four variables |

---

## Solution 2: Left-Right Prefix DP — O(n) time, O(n) space

**Idea:** For each split point `k`, the answer is `best_one_tx_left[k] + best_one_tx_right[k]`. Precompute:
- `left[i]` — max profit from at most one transaction in `prices[0..i]`.
- `right[i]` — max profit from at most one transaction in `prices[i..n-1]`.

Then sweep once and return `max(left[i] + right[i])`.

**Algorithm:**
1. Build `left[]` left-to-right (running min, track best gain so far).
2. Build `right[]` right-to-left (running max, track best gain so far).
3. Return `max(left[i] + right[i])` for all `i`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — three passes |
| Space | O(n) — two auxiliary arrays |
