# 446. Arithmetic Slices II - Subsequence — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/arithmetic-slices-ii-subsequence/

---

## Solution: DP with HashMaps — O(n²) time, O(n²) space

**Idea:** `dp[i]` is a HashMap where `dp[i][diff]` = number of **weak** arithmetic subsequences ending at index `i` with common difference `diff` (length ≥ 2). For each pair `(j, i)` with `diff = nums[i] - nums[j]`, any weak subsequence ending at `j` with same diff can be extended to a valid one (length ≥ 3).

**Algorithm:**
1. For each `i`, create `dp[i]` = new HashMap.
2. For each `j < i`: compute `diff = nums[i] - nums[j]`.
3. `count = dp[j].getOrDefault(diff, 0)`. Add `count` to global answer.
4. `dp[i][diff] += count + 1` (the `+1` counts the new weak pair `(j,i)`).

**Complexity:**

| | |
|---|---|
| Time | O(n²) |
| Space | O(n²) — total entries across all maps |
