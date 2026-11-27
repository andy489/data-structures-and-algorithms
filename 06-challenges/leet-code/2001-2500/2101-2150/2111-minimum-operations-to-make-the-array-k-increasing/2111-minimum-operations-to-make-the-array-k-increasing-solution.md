# 2111. Minimum Operations to Make the Array K-Increasing — Solution

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/minimum-operations-to-make-the-array-k-increasing/

---

## Solution: LIS (Longest Non-Decreasing Subsequence) on each stride — O(n log n) time, O(n) space

**Idea:** The array elements at positions `{r, r+k, r+2k, ...}` for each starting remainder `r ∈ {0, 1, ..., k-1}` form `k` independent subsequences. Each subsequence must be non-decreasing for the array to be K-increasing.

For each subsequence, the minimum number of changes = length of subsequence - length of its **Longest Non-Decreasing Subsequence (LNDS)**. This is because we keep the longest already-valid subsequence unchanged and modify the rest.

**LNDS via patience sorting (binary search):**
- Maintain a `tails` array where `tails[i]` is the smallest tail of all non-decreasing subsequences of length `i+1`.
- For each element `x`, binary search for the first tail > x (since we allow equal elements). Insert/replace at that position.
- Length of LNDS = `tails.length`.

**Algorithm:**
1. For `r = 0` to `k-1`:
   - Extract subsequence `sub = [arr[r], arr[r+k], arr[r+2k], ...]`.
   - Compute LNDS length using binary search.
   - Add `sub.length - LNDS` to result.
2. Return result.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — k subsequences of total length n, each processed in O(m log m) |
| Space | O(n/k) per subsequence, O(n) total |
