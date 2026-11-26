# 1365. How Many Numbers Are Smaller Than the Current Number — Solution

## Approach
Counting sort. prefix[v] = number of elements < v.

## Complexity
- Time: O(n + max_val)
- Space: O(max_val)
