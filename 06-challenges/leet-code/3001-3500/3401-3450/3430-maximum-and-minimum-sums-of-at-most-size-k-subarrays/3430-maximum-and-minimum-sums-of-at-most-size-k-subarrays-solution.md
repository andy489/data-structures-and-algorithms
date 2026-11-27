# Solution: 3430. Maximum and Minimum Sums of at Most Size K Subarrays

**Link:** https://leetcode.com/problems/maximum-and-minimum-sums-of-at-most-size-k-subarrays/

## Approach

For each element nums[i], compute how many subarrays of length at most k have nums[i] as their maximum, and how many have nums[i] as their minimum.

For maximum contribution of nums[i]:
- Find left boundary: leftMax[i] = last index j < i where nums[j] > nums[i] (or -1).
- Find right boundary: rightMax[i] = first index j > i where nums[j] >= nums[i] (or n).
- Subarrays where nums[i] is max and length <= k: consider subarrays [l, r] where leftMax[i] < l <= i <= r < rightMax[i] and r-l+1 <= k.
- Count using left reach = min(i - leftMax[i], k) and right reach = min(rightMax[i] - i, k).
- Contribution of nums[i] as max = nums[i] * sum over valid left choices.

For minimum contribution, same logic with flipped comparison.

Using monotonic stacks to find left/right boundaries in O(n), then O(1) per element.

## Complexity

- Time: O(n)
- Space: O(n)
