# 3352. Count K-Reducible Numbers Less Than N — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-k-reducible-numbers-less-than-n/

---

## Solution: Digit DP + Popcount Reduction Check — O(n^2) time, O(n^2) space

**Idea:** We want to count numbers with fewer than `len(s)` bits (or same length but strictly less) whose popcount is itself k-reducible in at most k-1 more steps.

Key insight:
1. First, precompute for each integer `c` from 1 to `len(s)`, how many steps it takes to reach 1 by repeated popcount. If it takes `steps(c) < k` steps, then any number whose popcount equals `c` is k-reducible.
2. Use digit DP: count numbers < n with exactly `c` set bits, summed over all k-reducible `c`.

**Algorithm:**
1. Compute `steps[c]` for c in [1..len]: `steps[1]=0`, `steps[c] = 1 + steps[popcount(c)]`.
2. The valid set-bit counts are those where `steps[c] < k` (and `c >= 1`).
3. For counting n-bit numbers with exactly `c` set bits that are `< n`: use digit DP on the binary string, tracking how many bits are still "tight" and how many 1s remain to place. This reduces to choosing positions in a binomial-coefficient manner.
4. Specifically: iterate over bits of `s` left to right. When we set bit `i` to 0 (while `s[i]=1`), we can freely place the remaining `c - ones_so_far` ones in the remaining bits — count via `C(remaining_positions, remaining_ones)`.
5. Sum over all valid `c`.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) — n = len(s) ≤ 800; digit DP is O(n) per c, c ranges up to n |
| Space | O(n^2) — Pascal's triangle for binomial coefficients |
