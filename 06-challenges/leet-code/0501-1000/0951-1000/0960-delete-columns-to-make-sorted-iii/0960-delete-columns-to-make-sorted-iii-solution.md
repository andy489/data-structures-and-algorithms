# 960. Delete Columns to Make Sorted III — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/delete-columns-to-make-sorted-iii/

---

## Solution: LIS on Columns — O(m²n) time, O(m) space

**Idea:** Find longest increasing subsequence of columns (where "increasing" means every row's character is non-decreasing). The answer is m minus this LIS length.

**Algorithm:**
1. `dp[j]` = length of longest valid column subsequence ending at column j.
2. For each pair (i, j), check if column j can extend the subsequence ending at i.
3. Answer = m - max(dp).

**Complexity:**

| | |
|---|---|
| Time | O(m²n) — m columns, n rows |
| Space | O(m) — dp array |
