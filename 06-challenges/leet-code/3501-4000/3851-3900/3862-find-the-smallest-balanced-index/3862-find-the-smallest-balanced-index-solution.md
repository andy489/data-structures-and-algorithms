# 3862. Find the Smallest Balanced Index — Solution

**Link:** https://leetcode.com/problems/find-the-smallest-balanced-index/

## Approach: Prefix Sum + Suffix Product

1. Compute prefix sums: `prefixSum[i]` = sum of nums[0..i-1].
2. Compute suffix products: `suffixProd[i]` = product of nums[i+1..n-1].
3. For each index `i`, check if `prefixSum[i] == suffixProd[i]`.

**Overflow concern:** Products can be astronomically large when nums[i] > 1. However, as soon as the product exceeds the maximum possible prefix sum (which is at most 10^5 * 10^9 = 10^14), we know the product can't equal any prefix sum. We can use this as an early-exit condition.

## Complexity

- **Time:** O(n)
- **Space:** O(n)
