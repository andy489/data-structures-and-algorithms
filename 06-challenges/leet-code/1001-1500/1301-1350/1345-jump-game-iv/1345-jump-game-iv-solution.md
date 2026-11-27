# 1345. Jump Game IV — Solution

## Approach
BFS. Group indices by value. From each index, explore i±1 and all same-value indices. Remove a group after visiting to avoid re-processing.

## Complexity
- Time: O(n)
- Space: O(n)
