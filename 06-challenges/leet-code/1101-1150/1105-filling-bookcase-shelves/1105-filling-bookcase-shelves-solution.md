# 1105. Filling Bookcase Shelves — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/filling-bookcase-shelves/

---

## Solution: Dynamic Programming — O(n²) time, O(n) space

**Idea:** `dp[i]` = minimum total height to place the first `i` books. For each book `i`, we try starting a new shelf and see how many previous books can fit alongside it. We track the maximum height and minimum width on the current shelf as we scan backwards.

**Algorithm:**
1. Initialize `dp[0] = 0`; `dp[i] = INF` for all `i > 0`.
2. For each book `i` (1-indexed), scan `j` backwards from `i` down to `1`:
   - Accumulate the thickness of books `j..i`. If it exceeds `shelfWidth`, stop.
   - Track `maxH` = max height among books `j..i`.
   - Update `dp[i] = min(dp[i], dp[j-1] + maxH)`.
3. Return `dp[n]`.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — for each of n books, we scan back up to n books |
| Space | O(n) — the dp array |
