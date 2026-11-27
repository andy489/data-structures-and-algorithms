# 2146. K Highest Ranked Items Within a Price Range — Solution

## Approach: BFS + Custom Sort

**Key insight:** Use BFS from the starting position to find all reachable cells at minimum distance. For each cell in the price range, record `(distance, price, row, col)`. Then sort by these 4 criteria and return the first k positions.

**Algorithm:**
1. BFS from `start`, tracking distance to each reachable cell.
2. For each reachable cell with price in `[low, high]`, add `{dist, price, row, col}` to candidates list.
3. Sort candidates by `(dist, price, row, col)`.
4. Return the first `k` positions (or all if fewer than k).

## Complexity

| | Time | Space |
|---|---|---|
| BFS traversal | O(m * n) | O(m * n) |
| Sorting candidates | O(c log c) where c ≤ m*n | O(c) |
| **Total** | **O(m * n * log(m * n))** | **O(m * n)** |
