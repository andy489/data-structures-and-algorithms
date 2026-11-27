# 1372. Longest ZigZag Path in a Binary Tree — Solution

## Approach
DFS. Each call returns (left_len, right_len). left_len = max zigzag ending going left from parent.

## Complexity
- Time: O(n)
- Space: O(h)
