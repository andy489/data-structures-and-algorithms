# 1338. Reduce Array Size to The Half — Solution

## Approach
Count frequencies, sort descending. Greedily pick most frequent elements until removed >= n/2.

## Complexity
- Time: O(n log n)
- Space: O(n)
