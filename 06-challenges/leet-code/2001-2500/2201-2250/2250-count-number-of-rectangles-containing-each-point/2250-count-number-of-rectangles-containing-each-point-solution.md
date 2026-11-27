# 2250. Count Number of Rectangles Containing Each Point — Solution

## Approach

Since `hi, yj <= 100` (small range), group rectangles by height. For each height `h`, store all lengths of rectangles with that height in a sorted list.

For each point `(x, y)`, iterate over all heights `h >= y`. For each such height, binary search in the sorted lengths list to count how many rectangles have length `>= x` (i.e., use `upperBound` or `bisect_left` to find the first position where length `>= x`).

This gives O(100 * log(n)) per point, which is efficient enough.

## Complexity

- **Time:** O((r + p) * H * log(r)) where H = 100, r = rectangles, p = points
- **Space:** O(r)
