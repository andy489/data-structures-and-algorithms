# 2134. Minimum Swaps to Group All 1's Together II — Solution

**Link:** https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/

## Approach: Sliding Window on Circular Array

The number of swaps needed to place all 1s in a window of size `k` (where `k` = total count of 1s) equals `k - (number of 1s already in that window)`.

Minimize swaps by maximizing the number of 1s in a sliding window of size `k` over the circular array. Handle the circular nature by doubling the array (or using modulo indexing).

Steps:
1. Count total 1s = `k`.
2. Use a sliding window of size `k` over the array (doubled to handle circularity).
3. Track the max count of 1s in any window.
4. Answer = `k - maxOnes`.

## Complexity

| | Time | Space |
|---|---|---|
| **Sliding Window** | O(n) | O(1) |

Where `n` is the length of the array.
