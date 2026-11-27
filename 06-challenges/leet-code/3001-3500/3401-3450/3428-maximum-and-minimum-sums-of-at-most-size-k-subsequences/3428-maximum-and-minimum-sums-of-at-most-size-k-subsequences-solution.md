# Solution: 3428. Maximum and Minimum Sums of at Most Size K Subsequences

**Link:** https://leetcode.com/problems/maximum-and-minimum-sums-of-at-most-size-k-subsequences/

## Approach

After sorting nums, for each element nums[i]:
- As minimum: nums[i] appears as the minimum in all subsequences where nums[i] is the smallest. These are subsequences of size 1 to k where nums[i] is the first element. The remaining elements are chosen from {nums[i+1], ..., nums[n-1]}, giving C(n-1-i, 0) + C(n-1-i, 1) + ... + C(n-1-i, k-1) ways.
- As maximum: nums[i] appears as maximum in all subsequences where nums[i] is the largest. The remaining are from {nums[0], ..., nums[i-1]}, giving C(i, 0) + C(i, 1) + ... + C(i, k-1) ways.

Precompute prefix sums of combinations: sum_{j=0}^{k-1} C(m, j).

## Complexity

- Time: O(n log n + n*k) or O(n log n) with prefix sums
- Space: O(n)
