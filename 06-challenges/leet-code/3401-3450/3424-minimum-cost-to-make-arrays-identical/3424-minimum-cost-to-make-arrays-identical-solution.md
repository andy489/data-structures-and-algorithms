# Solution: 3424. Minimum Cost to Make Arrays Identical

**Link:** https://leetcode.com/problems/minimum-cost-to-make-arrays-identical/

## Approach

Key insight: The cost of element-wise adjustments is minimized when both arrays are sorted. Sorting arr optimally maps elements of arr to elements of brr.

1. Compute cost without rearranging: sum of |arr[i] - brr[i]| for all i.
2. Compute cost with sorting arr: sort arr, sort brr, then sum |sorted_arr[i] - sorted_brr[i]| + k (the rearrangement cost).
3. Return the minimum of the two.

The rearrangement allows us to reorder arr's elements optimally: by sorting both arrays, we minimize the total absolute differences.

## Complexity

- Time: O(n log n)
- Space: O(n)
