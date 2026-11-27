# 2201. Count Artifacts That Can Be Extracted

## Approach

Use a HashSet to store all excavated cells (encoded as `r * n + c`). Then for each artifact, check if every cell it covers is in the set. Since each artifact covers at most 4 cells, this is efficient.

**Algorithm:**
1. Encode each dug cell as `r * n + c` and add to a set.
2. For each artifact with corners (r1, c1) and (r2, c2), iterate over all cells in the rectangle.
3. If all cells are in the set, increment the result.

**Time Complexity:** O(D + A * 4) where D is the number of digs and A is the number of artifacts (each artifact covers at most 4 cells).  
**Space Complexity:** O(D)
