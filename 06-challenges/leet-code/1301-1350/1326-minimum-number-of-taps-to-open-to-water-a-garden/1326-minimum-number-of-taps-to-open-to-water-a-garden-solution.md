# 1326. Minimum Number of Taps to Open to Water a Garden — Solution

## Approach
Convert to interval covering. For each tap, map [max(0,i-r), min(n,i+r)]. Then greedy jump game: for each position, track max reachable end.

## Complexity
- Time: O(n)
- Space: O(n)
