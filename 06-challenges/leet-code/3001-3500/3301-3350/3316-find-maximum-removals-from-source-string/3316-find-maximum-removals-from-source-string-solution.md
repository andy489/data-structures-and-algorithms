# Solution: Find Maximum Removals From Source String

## Approach: Dynamic Programming

Define `dp[i][j]` = maximum number of indices we can remove from the first `i` characters of `source` while matching the first `j` characters of `pattern`.

**Transitions:** At each position `i` in source:
1. Skip position `i` (if `i` is in `targetIndices`, we "remove" it — this counts as a removal if we don't need it for pattern matching):
   - If `i` is in `targetIndices`, we can remove it: `dp[i+1][j] = max(dp[i+1][j], dp[i][j] + 1)`.
   - Otherwise, skip without increment: `dp[i+1][j] = max(dp[i+1][j], dp[i][j])`.
2. Use position `i` to match `pattern[j]` (if `source[i] == pattern[j]`):
   - `dp[i+1][j+1] = max(dp[i+1][j+1], dp[i][j])`.

Initialize `dp[0][0] = 0`, all others to `-infinity`.

Answer is `dp[n][m]`.

## Complexity

- **Time:** O(n * m) where n = len(source), m = len(pattern).
- **Space:** O(n * m) or O(m) with 1D rolling array.
