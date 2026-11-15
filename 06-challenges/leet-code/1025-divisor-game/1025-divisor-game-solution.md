# 1025. Divisor Game — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/divisor-game/

---

## Solution: Math — O(1) time, O(1) space

**Idea:** Alice wins if and only if `n` is even. If `n` is even, Alice picks `x = 1`, leaving Bob with an odd number. Every divisor of an odd number is odd, so Bob is forced to subtract an odd number from an odd number, giving Alice an even number again. This invariant holds until Bob is stuck at `n = 1` with no valid move. Conversely, if `n` is odd, every divisor `x` of `n` is odd, so Alice must hand Bob an even number — and Bob wins by the same strategy.

**Algorithm:**
1. Return `n % 2 == 0`.

**Complexity:**

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |

---

## Solution 2: Dynamic Programming — O(n²) time, O(n) space

**Idea:** Define `dp[i] = true` if the current player wins when the number on the board is `i`. The current player wins if there exists any valid divisor `x` of `i` such that `dp[i - x]` is `false` (the opponent loses from that state).

**Algorithm:**
1. Initialise `dp[1] = false` (no valid move from 1).
2. For each `i` from `2` to `n`: set `dp[i] = true` if any divisor `x` of `i` satisfies `!dp[i - x]`, otherwise `false`.
3. Return `dp[n]`.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — for each i, check all divisors up to i |
| Space | O(n) — dp array |
