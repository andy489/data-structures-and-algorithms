# Solution: Reshape the Matrix

## Approach
If `r * c != m * n`, return the original matrix. Otherwise map the flat index `i` to `(i / c, i % c)` and fill in row-major order.

**Time:** O(m * n) | **Space:** O(r * c)
