# 3340. Check Balanced String — Solution

## Approach: Single Pass Sum

Iterate through the string and accumulate the difference between even-indexed and odd-indexed digit sums. At each index, add the digit if the index is even, subtract if odd. The string is balanced when the final difference is zero.

**Steps:**
1. Initialize `diff = 0`.
2. For each index `i`, add `num[i] - '0'` to `diff` if `i` is even, subtract it if `i` is odd.
3. Return `diff == 0`.

## Complexity

- **Time:** O(n) — single pass through the string.
- **Space:** O(1) — constant extra space.
