# 1353. Maximum Number of Events That Can Be Attended — Solution

## Approach
Greedy with min-heap. Sort by start day. For each day, add all events starting today, attend the one ending earliest.

## Complexity
- Time: O(n log n)
- Space: O(n)
