# 3441. Minimum Cost Good Caption — Solution

## Approach

Dynamic programming where we partition the string into groups and assign each group a character.

**Key Observations:**
- A good caption is formed by groups of 3+ identical characters.
- We need to partition `caption` into consecutive groups of size >= 3 and assign a character to each group minimizing total changes.
- For a group `[l, r]` assigned character `c`, the cost = `sum of |caption[j] - c|` for j in [l, r]. This is minimized by choosing the median character.

**DP Definition:**
- `dp[i]` = minimum cost to form a good caption for `caption[0..i-1]`.
- Transition: for each valid group ending at `i` (size >= 3), try all characters `c` ('a'..'z').

**Optimization:**
- Precompute prefix sums of character frequencies to compute group cost in O(26) time.
- Group sizes can be 3, 4, or 5 (since 6 = 3+3, etc., we only need to try last group sizes 3, 4, 5).

**Lexicographic tie-breaking:**
- When costs are equal, prefer the lexicographically smallest caption. Track the choice (character) for each `dp[i]`.

**Impossibility:**
- If `n % 3 != 0` and we can't partition `n` into groups of size >= 3, return "". Actually `n < 3` is impossible (can't form even one group of 3). For `n >= 3`, any `n` can be partitioned (3+3+...+3, or 4+3+..., 3+4+..., etc., but `n=1,2` is impossible). Wait: `n=1` -> impossible, `n=2` -> impossible, `n>=3` with `n != 1 or 2 mod anything` - actually any `n >= 3` can be partitioned since `n = 3k`, `3k+1 = 3(k-1)+4`, `3k+2 = 3(k-1)+5`.

**Time Complexity:** O(n * 26 * 5) = O(n)
**Space Complexity:** O(n)
