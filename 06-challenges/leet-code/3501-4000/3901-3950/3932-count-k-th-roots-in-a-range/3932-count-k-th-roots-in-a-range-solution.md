# 3932. Count K-th Roots in a Range — Solution

## Approach: Enumerate Integer Roots

For `k >= 2`, the number of perfect k-th powers in `[l, r]` is bounded by `r^(1/k)`. For `k = 30` and `r = 10^9`, the maximum root is `10^(9/30) ≈ 2`, so we iterate very few values.

For `k = 1`, every integer is a 1st power, so the count is `r - l + 1`.

For `k >= 2`: Enumerate `x = 1, 2, 3, ...` and check if `x^k` falls in `[l, r]`. Count how many do. Stop when `x^k > r`.

**Edge case:** When `l == 0`, `0 = 0^k` for any k >= 1, so include it.

## Complexity

- **Time:** O(r^(1/k)) — iterating roots
- **Space:** O(1) — constant extra space
