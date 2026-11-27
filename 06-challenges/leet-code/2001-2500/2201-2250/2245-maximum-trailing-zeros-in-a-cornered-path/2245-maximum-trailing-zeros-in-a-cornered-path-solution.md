# 2245. Maximum Trailing Zeros in a Cornered Path — Solution

## Approach

Trailing zeros = min(count of 2s, count of 5s) in the product.

Precompute prefix sums for the count of factors 2 and 5 for each cell:
- `rowTwo[i][j]` = sum of factor-2 counts in row `i` from column `0` to `j`
- `rowFive[i][j]` = similar for 5
- `colTwo[i][j]` = sum of factor-2 counts in column `j` from row `0` to `i`
- `colFive[i][j]` = similar for 5

For each corner cell `(i, j)`, consider all 4 cornered path directions:
1. Left + Down: horizontal left part + vertical down part
2. Left + Up: horizontal left part + vertical up part
3. Right + Down: horizontal right part + vertical down part
4. Right + Up: horizontal right part + vertical up part

For each direction, compute total 2s and 5s, then take min. Track the global max.

## Complexity

- **Time:** O(m * n)
- **Space:** O(m * n)
