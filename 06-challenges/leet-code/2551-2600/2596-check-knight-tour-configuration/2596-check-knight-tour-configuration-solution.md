# Solution: 2596. Check Knight Tour Configuration

## Approach

Build a position lookup: for each move number `m` in `[0, n*n-1]`, record its `(row, col)`.

Then verify that for each consecutive pair of moves `m` and `m+1`, the difference in row and column satisfies a valid knight move pattern:
- `|dr|` and `|dc|` must be `{1, 2}` (one of them is 1, the other is 2).

Also verify that `grid[0][0] == 0` (knight starts at top-left).

## Complexity

- **Time:** O(n^2)
- **Space:** O(n^2) for the position array
