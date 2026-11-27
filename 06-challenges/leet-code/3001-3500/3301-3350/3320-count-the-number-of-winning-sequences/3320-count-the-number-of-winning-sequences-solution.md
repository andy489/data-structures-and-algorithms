# Solution: Count the Number of Winning Sequences

## Approach: Dynamic Programming

Define `dp[i][last][score_diff]` = number of ways Bob can play the first `i` rounds, ending with creature `last`, with score difference `score_diff` (Bob's score - Alice's score).

**Score difference range:** from `-n` to `n`, so we shift by `n` to use as array index.

**Transitions:** For each round `i`:
- Bob picks creature `c` (0=F, 1=W, 2=E), `c != last`.
- Determine score: +1 if Bob wins this round, -1 if Alice wins, 0 if tie.
- Update `dp[i+1][c][score_diff + delta]`.

**Answer:** Sum all `dp[n][last][score > n]` (score_diff > 0 after shifting by n means index > n).

Optimized: Use 2D DP (last creature, score difference), process round by round.

## Complexity

- **Time:** O(n^2) — n rounds, 3 creatures, 2n+1 score differences.
- **Space:** O(n) per round (rolling).
