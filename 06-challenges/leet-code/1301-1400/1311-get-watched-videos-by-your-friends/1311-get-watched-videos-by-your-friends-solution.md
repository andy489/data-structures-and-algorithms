# 1311. Get Watched Videos by Your Friends — Solution

## Approach
BFS from id to find all friends at level k. Collect all videos they watched, sort by frequency then alpha.

## Complexity
- Time: O(n + E + V log V) where V = unique videos
- Space: O(n)
