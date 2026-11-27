# Solution: 2587. Rearrange Array to Maximize Prefix Score

## Approach

To maximize the number of positive prefix sums, sort the array in **descending order**. This way, the largest values come first and keep the running prefix sum positive for as long as possible.

After sorting, compute the prefix sums and count how many are strictly positive. Once the prefix sum becomes non-positive, all subsequent ones will be non-positive too (remaining elements are <= current element), so we can break early.

## Complexity

- **Time:** O(n log n) for sorting
- **Space:** O(1) extra space (sorting in place)
