# 3937. Minimum Operations to Make Array Modulo Alternating I

## Approach

For each pair `(x, y)` where `0 <= x, y < k` and `x != y`, count the total operations needed: for each element at an even index, the minimum operations to make it have remainder `x` mod `k`; for each element at an odd index, minimum operations to make it have remainder `y` mod `k`.

The minimum operations to change `a` to have remainder `r` mod `k` is `min(a % k >= r ? a % k - r : k - r + a % k, r >= a % k ? r - a % k : k - a % k + r)`, i.e., `min((a % k - r + k) % k, (r - a % k + k) % k)`.

Optimize: for even indices and odd indices separately, count the frequency of each remainder `0..k-1`. For a given `x`, the cost for even indices = sum over even-indexed elements of `min((rem - x + k) % k, (x - rem + k) % k)`. Precompute these counts, then iterate over all valid `(x, y)` pairs with `x != y` and pick the minimum total cost.

Since `k <= 100`, iterating over O(k^2) pairs and computing cost in O(1) with prefix sums over remainder frequencies is efficient.

## Complexity

- **Time:** O(n + k^2) — where n is array length and k is the modulus
- **Space:** O(k) — for frequency arrays
