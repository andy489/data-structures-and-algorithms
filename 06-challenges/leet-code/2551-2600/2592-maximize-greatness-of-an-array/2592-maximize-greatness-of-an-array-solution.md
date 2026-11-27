# Solution: 2592. Maximize Greatness of an Array

## Approach

This is the classic "task scheduling" / "maximize assignments" problem. Sort `nums`. Then use a two-pointer greedy approach:

- Use pointer `p` for the original sorted array and pointer `i` for the permutation.
- For each element in the sorted permutation, try to find the smallest element in the original array that it can exceed.
- This is equivalent to: after sorting, find the maximum number of elements in a permutation that can strictly exceed the original sorted array at the same position.

The answer is `n - (count of duplicates that can't be exceeded)`. A simpler way: sort, then use two pointers: match each `nums[p]` with the smallest `nums[i]` where `nums[i] > nums[p]`.

## Complexity

- **Time:** O(n log n) for sorting
- **Space:** O(1) extra space
