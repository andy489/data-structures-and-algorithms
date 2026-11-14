# 96. Unique Binary Search Trees — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/unique-binary-search-trees/

---

## Solution: Dynamic Programming (Catalan Number) — O(n²) time, O(n) space

**Idea:** Let `G(n)` = number of unique BSTs with `n` nodes. For each choice of root `i` (1 ≤ i ≤ n), the left subtree uses values `1..i-1` (giving `G(i-1)` trees) and the right subtree uses values `i+1..n` (giving `G(n-i)` trees). The total is the sum over all root choices. This yields the nth Catalan number.

**Algorithm:**
1. Initialize `dp[0] = dp[1] = 1`.
2. For each `k` from `2` to `n`: `dp[k] = sum of dp[i-1] * dp[k-i]` for `i` from `1` to `k`.
3. Return `dp[n]`.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — outer loop over n, inner loop over each root choice |
| Space | O(n) — the dp array |

---

## Solution 2: Closed-Form Catalan Number — O(n) time, O(1) space

**Idea:** The answer is the nth Catalan number: `C(n) = C(2n, n) / (n + 1)`. Compute it directly using the multiplicative formula to avoid large intermediate factorials.

**Algorithm:**
1. Start with `result = 1`.
2. For `i` from `0` to `n-1`: `result = result * (2*n - i) / (i + 1)` (integer division at each step preserves exactness for Catalan numbers).
3. Return `result / (n + 1)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single loop |
| Space | O(1) — constant extra space |
