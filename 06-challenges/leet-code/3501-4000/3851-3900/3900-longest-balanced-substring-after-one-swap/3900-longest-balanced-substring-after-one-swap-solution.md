# Solution: 3900. Longest Balanced Substring After One Swap

## Approach: Sliding Window + Parity

A balanced substring has equal numbers of '0's and '1's, so its length must be even.

### Key Observations

1. A swap can fix at most one imbalance point. For a window to become balanced after one swap, it needs:
   - Already balanced (count0 == count1): length = 2 * count0.
   - Off by 2 (|count0 - count1| == 2): a swap of a character outside the window with one inside can fix this, IF such characters exist outside. Length = 2 * min(count0, count1) + 2.

2. We need to check for each window if the fix is feasible.

### Algorithm

Use a sliding window approach:
1. Count total zeros and ones in the string.
2. For each window of even length L (try all even lengths from large to small, or use two-pointer):
   - Track `cnt0` and `cnt1` in the window.
   - If `cnt0 == cnt1`: valid balanced.
   - If `cnt0 - cnt1 == 2`: valid if there's a '1' outside (total1 - cnt1 >= 1).
   - If `cnt1 - cnt0 == 2`: valid if there's a '0' outside (total0 - cnt0 >= 1).
3. Find the maximum valid window length.

The two-pointer approach gives O(N) time.

## Complexity

- **Time:** O(N)
- **Space:** O(1)
