# 1376. Time Needed to Inform All Employees — Solution

## Approach
Build adjacency list (manager -> subordinates). DFS from head, return max time to leaf.

## Complexity
- Time: O(n)
- Space: O(n)
