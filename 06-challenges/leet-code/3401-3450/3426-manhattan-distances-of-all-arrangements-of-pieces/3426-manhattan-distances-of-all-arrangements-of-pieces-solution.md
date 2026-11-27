# Solution: 3426. Manhattan Distances of All Arrangements of Pieces

**Link:** https://leetcode.com/problems/manhattan-distances-of-all-arrangements-of-pieces/

## Approach

For each pair of pieces (i, j) across all valid arrangements, we sum their Manhattan distance.

Key insight: We can decompose Manhattan distance into row-distance + col-distance contributions.

For a pair of cells (r1, c1) and (r2, c2):
|r1-r2| + |c1-c2|

Consider the row contribution separately. For all arrangements of k pieces on m*n grid:
- Fix two positions p1 and p2 for a pair.
- The remaining k-2 pieces can be placed in C(m*n - 2, k-2) ways.
- Sum over all ordered pairs of distinct cells.

For each pair of cells (p1, p2), contribution = C(m*n - 2, k - 2) * (|r1-r2| + |c1-c2|).
Total = C(m*n-2, k-2) * sum_{all pairs p1<p2} (|r1-r2| + |c1-c2|).

Row contribution: sum over all pairs (r1, r2) with r1 != r2 or c1 != c2 of |r1-r2|.
This equals n^2 * sum_{r1, r2} |r1-r2| + correction...

Actually: sum of |r1-r2| over all ordered pairs of distinct cells = n^2 * sum_{r1 != r2}|r1-r2| + ... 
Simplify: sum_{all pairs of distinct cells}|r1-r2| = n^2 * S_rows where S_rows = sum_{i<j}(j-i) for i,j in [0,m-1].
Similarly for columns.

S_rows = sum_{i<j}(j-i) = sum_{d=1}^{m-1} d*(m-d).
S_cols = sum_{d=1}^{n-1} d*(n-d).

Total sum of Manhattan dist over all ordered pairs of cells = 2 * (n^2 * S_rows + m^2 * S_cols).
But we want unordered pairs, so divide by 2... but C(m*n-2, k-2) handles counts.

Final answer = C(m*n-2, k-2) * (n^2 * S_rows + m^2 * S_cols) mod 10^9+7.

## Complexity

- Time: O(m + n)
- Space: O(m*n) for factorials
