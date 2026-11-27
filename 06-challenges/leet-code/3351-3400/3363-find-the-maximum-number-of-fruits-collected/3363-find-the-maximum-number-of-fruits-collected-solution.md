# 3363. Find the Maximum Number of Fruits Collected — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-the-maximum-number-of-fruits-collected/

---

## Solution: Independent DP for Each Side Child — O(n^2) time, O(n^2) space

**Idea:** The child from `(0,0)` always travels the main diagonal (forced diagonal movement). The key insight: child 1 at `(0,0)` must always move diagonally (down-right) to reach `(n-1,n-1)` in exactly `n-1` steps — so they always take the main diagonal path. Their total is fixed: `sum(fruits[i][i])`.

Child 2 from `(0, n-1)` can move down-left, down, or down-right — but must always go down (row strictly increases). Child 3 from `(n-1, 0)` can move up-right, right, or down-right — but must always go right (column strictly increases). These two children are symmetric (rotation by 90°), so we apply the same DP approach to both.

For child 2 (top-right to bottom-right), DP on rows: `dp[i][j]` = max fruits collectible by child 2 in the first `i` rows ending at column `j`. Transition: `dp[i][j] = max(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1]) + fruits[i][j]`, but we must not count cells already visited by child 1 (i.e., `j == i` → subtract `fruits[i][j]`, or zero it out).

For child 3 (bottom-left to bottom-right), DP on columns: `dp[i][j]` = max fruits collectible in the first `j` columns ending at row `i`. Similar transitions, avoiding overlap with child 1.

The two side-children's paths never overlap with each other (by symmetry their domains are distinct), so the total = diagonal sum + max for child 2 + max for child 3.

**Algorithm:**
1. Compute `diag = sum(fruits[i][i])` for `i in [0,n-1]`.
2. Run DP for child 2 (from `(0,n-1)`, going down): zero out diagonal cells during DP, return `dp[n-1][n-1]`.
3. Run DP for child 3 (from `(n-1,0)`, going right): zero out diagonal cells during DP, return `dp[n-1][n-1]`.
4. Return `diag + child2 + child3`.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) — two DP passes of size n×n |
| Space | O(n^2) — DP tables (can be reduced to O(n) with rolling array) |
