# 2934. Minimum Operations to Maximize Last Elements in Arrays — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-operations-to-maximize-last-elements-in-arrays/

---

## Solution: Try Both Last-Element Configurations — O(n) time, O(1) space

**Idea:** The last elements `nums1[n-1]` and `nums2[n-1]` are either swapped or not. Try both configurations. For each configuration, determine the minimum swaps needed among indices `0..n-2`: for each index `i`, if `nums1[i] <= a` and `nums2[i] <= b` (where `a`, `b` are the target last elements), no swap is needed. If only the swapped pair works (`nums2[i] <= a` and `nums1[i] <= b`), one swap is needed. Otherwise, the configuration is impossible. Return the minimum across the two configurations.

**Algorithm:**
1. Let `a = nums1[n-1]`, `b = nums2[n-1]`.
2. Count swaps for no-swap-of-last configuration.
3. Count swaps for swap-of-last configuration (using `b, a` as targets; add 1 for the swap of the last).
4. Return `min` of the two valid counts; if both are impossible, return `-1`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
