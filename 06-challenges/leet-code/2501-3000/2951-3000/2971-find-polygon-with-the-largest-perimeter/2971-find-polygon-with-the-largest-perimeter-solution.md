# Solution: Find Polygon With the Largest Perimeter

## Approach: Sort + Prefix Sum Greedy

Sort the array. The key insight is: a valid polygon can be formed from elements a[0..i] if and only if prefix_sum[0..i-1] > a[i] (the sum of all smaller sides exceeds the largest side).

Iterate from largest to smallest, tracking the running prefix sum. The first position where sum of previous elements > current element gives the largest valid polygon perimeter.

## Complexity

| | Time | Space |
|---|---|---|
| **Sort + Linear Scan** | **O(n log n)** | **O(1)** |

## Key Insight

After sorting, we just scan from the end: if prefix sum of elements before index i > nums[i], then all elements from 0 to i form a valid polygon. We want the largest such perimeter, which is the full prefix sum up to index i.
