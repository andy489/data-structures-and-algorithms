# 2911. Minimum Changes to Make K Semi-palindromes — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-changes-to-make-k-semi-palindromes/

---

## Solution 1: DP with Precomputed Semi-palindrome Costs — O(n³) time, O(n²) space

**Idea:**

Precompute `cost[i][j]` = minimum changes to make the substring `s[i..j]` a semi-palindrome. For each valid divisor `d` of the length `len = j - i + 1` (where `1 ≤ d < len`), we split the substring into `d` interleaved groups and compute how many changes each group needs to become a palindrome (the answer is `⌊mismatches / 2⌋` using two pointers). We take the minimum over all valid `d`.

Then solve `dp[i][p]` = minimum changes to partition `s[0..i-1]` into exactly `p` semi-palindromes, transitioning over all split points `j`.

**Algorithm:**
1. Precompute `cost[i][j]` for all `0 ≤ i ≤ j < n`:
   - For each divisor `d` of `len = j - i + 1` with `1 ≤ d < len`:
     - For each group start `g ∈ [0, d-1]`, collect the sequence `s[i+g], s[i+g+d], s[i+g+2d], ...` and count mismatches from both ends (min changes to palindrome = `mismatches / 2`).
   - `cost[i][j]` = min over all valid `d`.
2. Initialize `dp[i][1] = cost[0][i-1]` for all `i`.
3. For `p` from `2` to `k`:
   - For each endpoint `i` from `p` to `n`:
     - `dp[i][p] = min over j in [p-1, i-1] of (dp[j][p-1] + cost[j][i-1])`
4. Return `dp[n][k]`.

**Complexity:**

| | |
|---|---|
| Time | O(n³) — O(n²) substrings × O(n) divisor/cost computation |
| Space | O(n²) — cost and dp tables |

---

## Solution 2: DP with Inline Cost Computation — O(n³) time, O(n²) space

**Idea:** Same DP structure, but compute the semi-palindrome cost inline during the DP transition instead of a separate precomputation pass. Equivalent time/space, but the single-pass structure may be cleaner for implementation.

**Algorithm:**
1. Helper `semiCost(i, j)`: iterate over divisors `d` of `len`, sum palindrome costs per group, return the min.
2. `dp[p][i]` = min cost for first `i` chars in `p` parts.
3. Build up `dp` for `p = 1` to `k`, for each `i` scan all split points.
4. Return `dp[k][n]`.

**Complexity:**

| | |
|---|---|
| Time | O(n³) — same asymptotic as Solution 1 |
| Space | O(n²) — dp table + inline recomputation avoids storing the full cost table |
