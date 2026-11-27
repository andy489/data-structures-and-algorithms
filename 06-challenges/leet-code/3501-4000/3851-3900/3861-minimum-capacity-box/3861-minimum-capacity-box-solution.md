# 3861. Minimum Capacity Box — Solution

**Link:** https://leetcode.com/problems/minimum-capacity-box/

## Approach: Linear Scan

Scan all boxes, keeping track of the index with minimum capacity that is still >= itemSize. Return that index.

Since we want minimum capacity AND among ties the smallest index, we iterate left to right and update only when we find a strictly smaller valid capacity.

## Complexity

- **Time:** O(n)
- **Space:** O(1)
