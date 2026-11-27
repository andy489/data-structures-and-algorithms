# 3864. Minimum Cost to Partition a Binary String — Solution

**Link:** https://leetcode.com/problems/minimum-cost-to-partition-a-binary-string/

## Approach: Recursive Memoization (Divide and Conquer with Memoization)

The splitting structure is hierarchical: a segment of length `L` can be split only if `L` is even, into two equal halves. This means we can only create segments whose lengths are powers of 2 times the original starting position.

We recursively compute the minimum cost for every contiguous segment `[l, r]` (of even length) by either:
1. Keeping it as is: cost = `(r-l+1) * ones * encCost` if ones > 0, else `flatCost`.
2. Splitting in half (only if even length): cost = `minCost(l, mid) + minCost(mid+1, r)`.

Use memoization with `(l, r)` as key.

Since we can only split even-length segments into equal halves, the recursion tree has depth `log2(n)` and there are `O(n)` unique subproblems (each power-of-2-aligned interval). Total complexity is manageable.

## Complexity

- **Time:** O(n log n) with memoization
- **Space:** O(n log n) for the memo table
