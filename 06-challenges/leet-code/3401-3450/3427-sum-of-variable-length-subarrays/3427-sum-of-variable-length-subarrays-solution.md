# Solution: 3427. Sum of Variable Length Subarrays

**Link:** https://leetcode.com/problems/sum-of-variable-length-subarrays/

## Approach

Use a prefix sum array. For each index i, compute start = max(0, i - nums[i]), then the subarray sum is prefixSum[i+1] - prefixSum[start].

## Complexity

- Time: O(n)
- Space: O(n)
