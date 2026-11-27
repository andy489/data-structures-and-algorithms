# 2911. Minimum Changes to Make K Semi-palindromes — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-changes-to-make-k-semi-palindromes/

---

## Solution 1: DP with Precomputed Semi-palindrome Costs — O(n³) time, O(n²) space

**Idea:**

Break the problem into two independent subproblems:

1. **Cost table:** For every substring `s[i..j]`, compute `cost[i][j]` — the minimum number of character changes to make it a semi-palindrome.
2. **Partition DP:** Find the optimal way to split `s` into exactly `k` parts, minimising the total cost.

**Computing `cost[i][j]`:**

A string of length `len` is a semi-palindrome under divisor `d` if, for every group index `g ∈ [0, d-1]`, the characters at positions `g, g+d, g+2d, ...` form a palindrome. To make a sequence a palindrome with the fewest changes, pair up characters symmetrically from both ends and change one of each mismatched pair — so the cost per group is `⌊mismatches / 2⌋` (integer division already handles this since each mismatch contributes exactly 1 to the integer count).

For each valid `d` (i.e. `d | len` and `1 ≤ d < len`), iterate over the `d` groups. Group `g` starts at absolute index `i + g` and its mirror end is `j - (d - 1 - g)`. Use two pointers `lo` and `hi` moving inward by step `d` to count mismatches. Sum costs across all groups. Take the minimum over all valid `d`.

Strings of length 1 have no valid `d`, so they cannot be semi-palindromes; their cost is initialised to `∞` (represented as `Integer.MAX_VALUE / 2` to avoid overflow on addition).

**Partition DP:**

Define `dp[i][p]` = minimum total changes to partition `s[0..i-1]` into exactly `p` semi-palindromes.

- Base case: `dp[0][0] = 0`.
- Transition: `dp[i][p] = min over j in [p-1, i-1] of (dp[j][p-1] + cost[j][i-1])`.

The answer is `dp[n][k]`.

The DP loop bounds `i ∈ [p, n-(k-p)]` ensure each part is non-empty and enough characters remain for the remaining `k-p` parts.

**Algorithm:**
1. Initialise `cost[i][j] = ∞` for all pairs.
2. For each pair `i ≤ j`, try all valid divisors `d` of `len = j - i + 1`:
   - For each group `g ∈ [0, d-1]`, use two pointers with step `d` to count mismatches → palindrome cost.
   - Update `cost[i][j]` with the sum of group costs.
3. Initialise `dp[i][p] = ∞`; set `dp[0][0] = 0`.
4. For each `p` from `1` to `k`, for each endpoint `i`, for each split `j`, update `dp[i][p]`.
5. Return `dp[n][k]`.

**Complexity:**

| | |
|---|---|
| Time | O(n³) — O(n²) substrings × O(n) divisor/cost computation |
| Space | O(n²) — cost and dp tables |

---

## Solution 2: DP with Inline Cost Computation — O(n³) time, O(n²) space

**Idea:** Same DP structure, but `semiCost(i, j)` is called on-demand during the DP transition rather than precomputing the full table upfront. This avoids allocating the `n×n` cost table at the expense of recomputing costs whenever a split point is revisited. In practice both solutions share the same asymptotic behaviour; Solution 1 is preferable when the same substring cost is needed multiple times across different `p` values (which does happen), while Solution 2 trades memory for slightly simpler initialisation code.

The `semiCost` helper returns `Integer.MAX_VALUE / 2` for length-1 inputs (no valid `d` exists) so that adding it to any finite DP value does not overflow.

**Algorithm:**
1. Define `semiCost(i, j)` as described above, initialising `best = MAX/2` to handle length-1 gracefully.
2. `dp[p][i]` = min cost for first `i` chars split into `p` parts.
3. Build `dp` for `p = 1` to `k`; for each `i` scan all split points `j`, calling `semiCost(j, i-1)`.
4. Return `dp[k][n]`.

**Complexity:**

| | |
|---|---|
| Time | O(n³) — same asymptotic as Solution 1 |
| Space | O(n²) — dp table only; no separate cost table |
