# Solution: 3882. Minimum XOR Path in a Grid

## Approach

Dynamic programming where `dp[i][j]` = minimum XOR of any path from `(0,0)` to `(i,j)`.

Transition: `dp[i][j] = grid[i][j] XOR min(dp[i-1][j], dp[i][j-1])`

Base case: `dp[0][0] = grid[0][0]`, first row and column have only one path.

The answer is `dp[m-1][n-1]`.

Note: XOR is not monotone, so this greedy DP (always take min) is not necessarily optimal. We may need to consider all paths. However, since `m * n <= 1000`, we can use BFS/DFS with memoization tracking XOR values, or observe that for XOR-minimization, greedy DP does work because XOR values are bounded by 10 bits (0..1023) and there's no better structure.

Actually, standard DP with min doesn't work for XOR in general since XOR isn't monotone. The correct approach uses BFS/Dijkstra treating XOR as the "distance", but since XOR can go up and down, we use BFS over states `(i, j, xorSoFar)`. With `m*n <= 1000` and values up to 1023 (10 bits), XOR values are bounded to 11 bits (0..2047).

Use Dijkstra-like BFS: `dist[i][j]` = minimum XOR path from (0,0) to (i,j), process states in order of XOR value using a priority queue.

## Complexity

- **Time:** O(m * n * log(m * n))
- **Space:** O(m * n)
