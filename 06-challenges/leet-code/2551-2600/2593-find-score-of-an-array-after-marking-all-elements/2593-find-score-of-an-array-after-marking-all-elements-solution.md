# Solution: 2593. Find Score of an Array After Marking All Elements

## Approach

Use a **min-heap** (priority queue) that stores `(value, index)` pairs. Process elements in order of increasing value (ties broken by index):

1. Push all `(nums[i], i)` into a min-heap.
2. Maintain a `marked` boolean array.
3. While the heap is not empty, pop the minimum. If the element is already marked, skip it.
4. Otherwise, add its value to score, then mark it and its two neighbors (index-1 and index+1).

## Complexity

- **Time:** O(n log n) for heap operations
- **Space:** O(n) for the heap and marked array
