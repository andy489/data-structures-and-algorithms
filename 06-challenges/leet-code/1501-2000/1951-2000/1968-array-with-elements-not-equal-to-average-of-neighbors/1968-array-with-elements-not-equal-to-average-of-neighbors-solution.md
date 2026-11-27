# 1968. Array With Elements Not Equal to Average of Neighbors — Solution

## Approach

Sort the array, then interleave first half and second half: place smaller half at even indices and larger half at odd indices. This ensures no element is the average of its neighbors since adjacent elements alternate between small and large.

**Complexity:** O(n log n) time for sorting, O(n) space.
