# 1155. Number of Dice Rolls With Target Sum — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

---

## Solution: 1-D DP (Rolling Array) — O(n × target × k) time, O(target) space

**Idea:** Use bottom-up DP. `dp[s]` = number of ways to reach sum `s` using the dice rolled so far. For each die, update the DP array by considering all face values 1..k. Use a rolling array to keep space O(target).

**Algorithm:**
1. Initialize `dp[0] = 1` (one way to have sum 0 with 0 dice).
2. For each of the `n` dice, compute a new DP array `next` where `next[s]` = sum of `dp[s-f]` for `f` in `1..k`.
3. Use a prefix-sum optimization to compute each `next[s]` in O(1) amortized.
4. Return `dp[target] % MOD`.

**Complexity:**

| | |
|---|---|
| Time | O(n × target × k) — n dice, each updating target sums with up to k faces |
| Space | O(target) — single DP array |

---

## Solution 2: 2-D DP (Explicit Table) — O(n × target) time, O(n × target) space

**Idea:** `dp[i][s]` = number of ways to get sum `s` with the first `i` dice. Transition: `dp[i][s] = sum(dp[i-1][s-f])` for f in 1..k.

**Complexity:**

| | |
|---|---|
| Time | O(n × target × k) |
| Space | O(n × target) |
