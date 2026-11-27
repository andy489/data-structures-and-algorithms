# Solution: 3877. Minimum Removals to Achieve Target XOR

## Approach

We want to find a subset of `nums` with maximum size such that its XOR equals `target`. Then removals = n - max_subset_size.

Since `n <= 40`, use **meet-in-the-middle**:
1. Split array into two halves.
2. For the left half, enumerate all 2^20 subsets: record `(xor_value, subset_size)`.
3. For the right half, enumerate all 2^20 subsets: for each `(xorR, sizeR)`, we need left half to contribute `xorR ^ target`. Look up in left half map to find max `sizeL + sizeR`.
4. Store a map: `leftXor -> max count` from left enumeration.

We want to maximize the count of elements kept (i.e., the subset size). So `removals = n - max_kept`.

## Complexity

- **Time:** O(2^(n/2))
- **Space:** O(2^(n/2))
