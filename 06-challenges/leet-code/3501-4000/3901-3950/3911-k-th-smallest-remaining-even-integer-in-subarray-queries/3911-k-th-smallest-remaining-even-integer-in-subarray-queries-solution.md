# Solution for 3911. K-th Smallest Remaining Even Integer in Subarray Queries

## Approach

**Binary search on the answer:**

For each query `[l, r, k]`, we need the k-th smallest positive even integer not in `nums[l..r]`.

**Key insight:** The candidate answer is some even integer `ans = 2 * m`. Among `2, 4, 6, ..., 2*m`, let `removed` = count of even integers in `nums[l..r]` that are `<= 2*m`. Then `m - removed` even integers remain in `[2, 2*m]`. We want `m - removed = k`, so `m = k + removed`.

**Binary search:** Binary search on `m` (or equivalently on `ans = 2*m`). For a given `m`, count how many even values in `nums[l..r]` are `<= 2*m`. This count can be computed using prefix sums over the even values in `nums`.

**Prefix sums:** Precompute `prefix[i]` = count of even elements in `nums[0..i-1]` that are `<= v` for a given `v`. Since `nums` is sorted, the even elements in `nums[l..r]` with value `<= 2*m` can be found with binary search on the sorted array.

**Algorithm per query:**
1. Binary search `m` in range `[k, k + (r-l+1)]` (since at most r-l+1 evens can be removed).
2. For each candidate `m`: count evens in `nums[l..r]` <= 2*m using `upper_bound` on the subarray.
3. Find smallest `m` where `m - count(evens <= 2m in nums[l..r]) >= k`.

## Complexity

- Time: O(q * log(max_val) * log(n)) per query
- Space: O(n) for the input
