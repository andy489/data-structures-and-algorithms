# 1191. K-Concatenation Maximum Sum — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/k-concatenation-maximum-sum/

---

## Solution: Kadane + Total Sum — O(n) time, O(1) space

**Idea:** Three cases:
1. `k == 1`: plain Kadane's on `arr`.
2. `k >= 2`, `total <= 0`: the best subarray can span at most 2 copies (prefix of one copy + suffix of another). Run Kadane on `arr + arr`.
3. `k >= 2`, `total > 0`: same as case 2 but we can gain `(k-2) * total` extra by including all the middle copies.

**Algorithm:**
1. Compute `total = sum(arr)`.
2. Compute `maxSub2 = kadane(arr + arr)` (Kadane over two copies, capped at 0).
3. If `k == 1`: return `kadane(arr) % MOD`.
4. If `total > 0`: return `(maxSub2 + (long)(k - 2) * total) % MOD`.
5. Else: return `maxSub2 % MOD`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two passes over arr |
| Space | O(1) — scalar variables only |
