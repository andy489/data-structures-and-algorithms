# Solution: 3897. Maximum Value of Concatenated Binary Segments

## Approach: Greedy Sort by Segment Comparison

To maximize the concatenated binary value, we should place segments with more "1s at the front" before those with less. The standard greedy comparison: segment A should come before segment B if `A + B > B + A` (lexicographically, since all are binary strings).

### Key Insight

For binary numbers, a string with more leading 1s is bigger. The optimal sort order is: a segment `(ones, zeros)` should come before `(ones', zeros')` if comparing `A || B > B || A`. Equivalently:

`A * 2^(len(B)) + B > B * 2^(len(A)) + A`

### Algorithm

1. For each index, build a segment descriptor with `(ones, zeros)`.
2. Sort segments using the custom comparator above (working in modular arithmetic).
3. Concatenate all segments and compute the value modulo `10^9 + 7`.

The concatenated value = `result = 0`, then for each segment: `result = result * 2^(len(segment)) + val(segment)` (mod).

The value of a segment with `k` ones followed by `m` zeros: it's `(2^k - 1) * 2^m = 2^(k+m) - 2^m`.

## Complexity

- **Time:** O(N log N) for sorting + O(N) for computation
- **Space:** O(N) for segment storage
