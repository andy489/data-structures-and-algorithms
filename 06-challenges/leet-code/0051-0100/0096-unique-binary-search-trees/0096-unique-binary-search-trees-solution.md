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

## Proof: G(n) = Cₙ (nth Catalan Number)

The nth Catalan number satisfies:

```
C₀ = 1,   Cₙ = Σ Cᵢ · Cₙ₋₁₋ᵢ   (i = 0..n-1)
```

Our recurrence (root `i` from 1 to k):

```
G(0) = 1,   G(k) = Σ G(i-1) · G(k-i)   (i = 1..k)
```

Re-index with `j = i - 1` (j runs 0..k-1):

```
G(k) = Σ G(j) · G(k-1-j)   (j = 0..k-1)
```

This matches the Catalan recurrence exactly. Since `G(0) = 1 = C₀`, by induction `G(n) = Cₙ` for all n ≥ 0.

**Why the BST recurrence has this form:** Picking root `i` leaves `i-1` values for the left subtree and `k-i` for the right. Only the *count* matters (not the actual values), so both sides contribute independently — giving `G(i-1) · G(k-i)`. Summing over all k root choices yields the formula.

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
