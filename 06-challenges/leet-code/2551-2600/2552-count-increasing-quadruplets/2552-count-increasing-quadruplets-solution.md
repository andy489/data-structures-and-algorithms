# 2552. Count Increasing Quadruplets — Solution

## Approach: Dynamic Programming with Prefix Counts

**Key Insight:** For a quadruplet `(i, j, k, l)` to be valid we need `nums[i] < nums[k] < nums[j] < nums[l]`. We fix `j` and `k` (the "middle" pair where `nums[k] < nums[j]`), then count valid `i` values before `j` with `nums[i] < nums[k]`, and valid `l` values after `k` with `nums[l] > nums[j]`.

**Algorithm:**
1. Precompute `suf[j][v]` = count of indices `l > j` where `nums[l] > v`. (Use suffix counts.)
2. For each pair `(j, k)` where `j < k` and `nums[k] < nums[j]`:
   - Count `i < j` with `nums[i] < nums[k]` — maintain `pre[j][v]` as prefix count.
   - Count `l > k` with `nums[l] > nums[j]` — use precomputed suffix.
   - Multiply these two counts and add to result.

**Optimized DP:**
- `dp[j]` = number of valid `(i, j, k)` triples where `nums[i] < nums[k] < nums[j]`.
- Iterate over `k` from left to right. For each `k`:
  - For `j > k` with `nums[j] > nums[k]`: add to answer the count of `l > k` with `nums[l] > nums[j]` times dp[j].
  - Actually: iterate positions, maintaining `lessThanCurrent[j]` = count of `i < j` with `nums[i] < nums[k]`.

**Cleaner O(n²) DP:**
- `tree[j]` = count of valid triples ending at position `j` as the "big" element.
- For position `k` from left to right, before updating: for each `j > k` with `nums[j] > nums[k]`, `tree[j]` can gain contributions.

**Actual O(n²) approach:** `dp[j]` = number of `i < j` with `nums[i] < nums[k]` for some future `k`. We iterate `k` from 0 to n-1, and for each `k`, count pairs `(i, k)` with `nums[i] < nums[k]` by checking all `i < k`. Then for each `j > k` with `nums[j] > nums[k]`, that (i,j,k) triple contributes to `dp[j]`. Answer is `sum over j of dp[j] * (count of l > j with nums[l] > nums[j])`.

## Complexity

- **Time:** O(n²) — double loop over all pairs
- **Space:** O(n) — for the dp array
