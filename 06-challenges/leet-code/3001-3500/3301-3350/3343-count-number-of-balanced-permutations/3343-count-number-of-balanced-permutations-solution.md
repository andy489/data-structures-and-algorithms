# 3343. Count Number of Balanced Permutations — Solution

## Approach: DP with Combinatorics

A balanced permutation requires the total digit sum `S` to be even (since even-index sum = odd-index sum = S/2). Let `target = S/2`.

We need to count the number of ways to assign digits to even positions such that their sum equals `target`. With `n` characters, there are `ceil(n/2)` even positions and `floor(n/2)` odd positions.

**Algorithm:**
1. Count digit frequencies `cnt[0..9]`.
2. Use DP: `dp[i][j]` = number of ways to assign digits from `0..i` placing exactly `j` of them in even positions with the remaining sum constraint.
3. After DP, multiply by multinomial coefficient to account for arrangements within each group.

**More precisely:**
- Let `evenSlots = ceil(n/2)`, `oddSlots = floor(n/2)`.
- DP over digits 0–9: `dp[placed_in_even][sum_so_far]` = number of ways.
- Transition: for digit `d` with count `c`, decide how many `k` of them go to even positions (`0 <= k <= min(c, evenSlots - placed)`).
- The count of ways for this choice = C(c, k) * C(c-k, c-k) = C(c, k).
- Final answer = `dp[evenSlots][target]` divided by the product of `cnt[d]!` for each digit (to remove duplicate orderings within positions), then multiplied by `evenSlots! * oddSlots!`.

The formula: `answer = evenSlots! * oddSlots! / prod(cnt[d]!) * dp_ways`

We precompute factorials and modular inverses for efficiency.

## Complexity

- **Time:** O(10 * n * target) where n <= 80 and target <= 360.
- **Space:** O(n * target) — DP table.
