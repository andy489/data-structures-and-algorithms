# 1337. The K Weakest Rows in a Matrix — Solution

## Approach
Count soldiers per row (binary search since sorted), sort by (count, index), return first k indices.

## Complexity
- Time: O(m log n + m log m)
- Space: O(m)
