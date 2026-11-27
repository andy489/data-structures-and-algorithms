# Solution: 3890. Integers With Multiple Sum of Two Cubes

## Approach: Enumerate All Pairs and Count

Since `a^3 + b^3 <= n`, the maximum value of `a` or `b` is at most `cbrt(n)`. For `n <= 10^9`, this means `a, b <= 1000`.

### Algorithm

1. Enumerate all pairs `(a, b)` where `a <= b` and `a^3 + b^3 <= n`.
2. Use a map to track how many pairs produce each sum `x = a^3 + b^3`.
3. Collect all keys where the count is >= 2.
4. Sort and return.

### Why It Works

The taxicab numbers (sums expressible as sum of two cubes in multiple ways) are found by this brute-force enumeration. Since `cbrt(10^9) ≈ 1000`, the total pairs to check are O(1000^2 / 2) = ~500,000, which is fast.

## Complexity

- **Time:** O(cbrt(n)^2 * log(cbrt(n)^2)) for enumeration and sorting
- **Space:** O(cbrt(n)^2) for the map
