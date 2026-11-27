# Solution: 2574. Left and Right Sum Differences

## Approach: Prefix Sum

Compute prefix sums from both directions:

1. Build `leftSum` array where `leftSum[i]` = sum of `nums[0..i-1]`.
2. Build `rightSum` array where `rightSum[i]` = sum of `nums[i+1..n-1]`.
3. For each index, `answer[i] = |leftSum[i] - rightSum[i]|`.

**Optimization:** We can compute everything in a single pass using running totals:
- Precompute total sum.
- Iterate left to right, maintaining `leftRunning`. Then `rightRunning = total - leftRunning - nums[i]`.

## Complexity

- **Time:** O(n)
- **Space:** O(n) for the answer array (O(1) extra)
