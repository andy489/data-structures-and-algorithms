# Solution: 3420. Count Non-Decreasing Subarrays After K Operations

**Link:** https://leetcode.com/problems/count-non-decreasing-subarrays-after-k-operations/

## Approach

Sliding window with a monotonic deque.

For a subarray [l, r] to be made non-decreasing with at most k operations:
- The minimum cost is the sum of max(0, nums[i-1] - nums[i]) for each adjacent pair in the subarray, where we "cap" each element at the maximum seen so far from the left.
- This equals the total "drops" we need to fix by incrementing.

Use a sliding window [l, r] expanding r. Maintain a deque of indices with decreasing values (monotonic decreasing deque). When we add r:
- For each element popped from the deque (let its index be idx), it contributes (nums[idx] - nums[r]) * (idx - prev_idx) to the cost (where prev_idx is the previous element in the deque).
- Shrink l until cost <= k.
- Each valid right endpoint r contributes (r - l + 1) subarrays.

## Complexity

- Time: O(n)
- Space: O(n)
