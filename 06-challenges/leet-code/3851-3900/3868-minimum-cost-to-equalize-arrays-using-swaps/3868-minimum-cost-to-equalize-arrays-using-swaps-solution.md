# 3868. Minimum Cost to Equalize Arrays Using Swaps — Solution

**Link:** https://leetcode.com/problems/minimum-cost-to-equalize-arrays-using-swaps/

## Approach: Multiset / Sorted Pairs

The key observations:
1. Free swaps within an array allow us to rearrange each array arbitrarily.
2. For two arrays to be identical, they must share the exact same multiset of values (considering both arrays together have `2n` elements, split into two groups of `n` identical sets).
3. Combined multiset of `nums1` and `nums2` must have every value appearing an even number of times (since each value must appear the same number of times in nums1 and nums2).
4. If not all values appear even times total, return -1.
5. Each paid swap at index `i` exchanges `nums1[i]` and `nums2[i]`. We can arrange values freely within each array, so we're distributing pairs of values across positions.
6. At each position `i`, either `nums1[i] == nums2[i]` (same value at that position, 0 cost from this position) or they're different values (we can optionally swap at cost 1 to exchange).

The minimum number of paid swaps equals half the number of positions where the two sorted arrays differ — but after optimal free rearrangement.

Sort both arrays. Count positions where `sortedNums1[i] != sortedNums2[i]`. The answer is half this count. If the combined multiset doesn't have all even frequencies, return -1.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)
