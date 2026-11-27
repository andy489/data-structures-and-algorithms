# 3940. Limit Occurrences in Sorted Array

## Approach

Use a write pointer and a count variable. Traverse the array; for each element, track how many times the current element has been written. If the count is less than `k`, write it and increment the count. Reset count when the element changes (or use the write pointer position relative to the previous element).

Since the array is sorted, duplicates are contiguous. Use a simple approach: maintain a count of occurrences of the current element seen. If the count <= k, include the element in the result.

## Complexity

- **Time:** O(n) — single pass
- **Space:** O(1) extra (not counting output)
