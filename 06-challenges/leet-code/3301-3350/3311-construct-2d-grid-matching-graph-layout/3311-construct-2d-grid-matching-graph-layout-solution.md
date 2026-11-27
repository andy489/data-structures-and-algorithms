# Solution: Construct 2D Grid Matching Graph Layout

## Approach: Degree Analysis + BFS Row Construction

**Key insight:** In a valid grid with dimensions r x c:
- Corner nodes have degree 2.
- Edge nodes (non-corner) have degree 3.
- Interior nodes have degree 4.
- If grid is a single row/column (r=1 or c=1), endpoints have degree 1, interior have degree 2.

**Algorithm:**
1. Determine grid dimensions from degree counts:
   - Count nodes by degree. 4 nodes with degree 2 (corners), edge nodes with degree 3, interior with degree 4.
   - From `n`, find valid `r,c` such that `r*c = n`. Use degrees to determine which dimensions work.

2. Find a corner node (degree 2 or 1 for linear case).

3. Build the grid row by row: start from a corner, pick the next node in the row as the common neighbor of current node and previous row's corresponding node. Use adjacency sets for quick lookup.

## Complexity

- **Time:** O(n + m) where m = edges.length.
- **Space:** O(n + m).
