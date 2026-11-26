# 1383. Maximum Performance of a Team — Solution

## Approach
Sort by efficiency descending. For each engineer as the minimum efficiency, maintain a min-heap of size k for speeds. Performance = heap_sum * efficiency[i].

## Complexity
- Time: O(n log k)
- Space: O(k)
