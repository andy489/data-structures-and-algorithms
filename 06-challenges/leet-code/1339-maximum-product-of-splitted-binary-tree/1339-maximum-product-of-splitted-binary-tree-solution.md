# 1339. Maximum Product of Splitted Binary Tree — Solution

## Approach
First pass: compute total sum. Second pass: for each subtree sum s, compute s*(total-s). Take max then mod.

## Complexity
- Time: O(n)
- Space: O(h)
