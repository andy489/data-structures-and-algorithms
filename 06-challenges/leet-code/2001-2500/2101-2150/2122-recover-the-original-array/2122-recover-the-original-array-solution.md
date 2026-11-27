# 2122. Recover the Original Array — Solution

**Link:** https://leetcode.com/problems/recover-the-original-array/

## Approach: Try All Possible k Values

After sorting `nums`, the smallest element `nums[0]` must be in `lower`. Thus `nums[0] = arr[0] - k`, which means `2k = nums[j] - nums[0]` for some `j`. We try each candidate `j` (from 1 to 2n-1), compute `k = (nums[j] - nums[0]) / 2`, and validate:

1. `nums[j] - nums[0]` must be even and positive (k > 0).
2. Use a frequency map: for each unused element, find `x + 2k` in the map. If always found, we have a valid pairing.

The original array element is `(x + x + 2k) / 2 = x + k`.

## Complexity

| | Time | Space |
|---|---|---|
| **Try all k** | O(n^2) | O(n) |
