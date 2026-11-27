# 2132. Stamping the Grid — Solution

**Link:** https://leetcode.com/problems/stamping-the-grid/

## Approach: 2D Prefix Sums

Use two 2D prefix sum arrays:

1. **Prefix sum of grid**: For each potential stamp top-left corner `(r, c)`, check if the `stampHeight x stampWidth` region has no occupied cells (sum == 0 in that region). If valid, mark that stamp placement.

2. **Prefix sum of valid stamps**: For each empty cell `(r, c)` in the grid, check if at least one valid stamp covers it. A stamp with top-left corner `(r2, c2)` covers `(r, c)` if `r2 <= r <= r2+h-1` and `c2 <= c <= c2+w-1`, i.e., `r-h+1 <= r2 <= r` and `c-w+1 <= c2 <= c`. Use the second prefix sum to check if any valid stamp placement exists in that range.

If any empty cell is not covered by any valid stamp, return false.

## Complexity

| | Time | Space |
|---|---|---|
| **2D Prefix Sums** | O(m*n) | O(m*n) |

Where `m` and `n` are the grid dimensions.
