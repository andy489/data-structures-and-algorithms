# Solution: 3898. Find the Degree of Each Vertex

## Approach: Row Sum of Adjacency Matrix

For an undirected graph represented as an adjacency matrix, the degree of vertex `i` is simply the sum of row `i` (or equivalently column `i` since it's symmetric).

### Algorithm

1. For each vertex `i`, sum all values in `matrix[i]`.
2. Return the array of sums.

### Why It Works

`matrix[i][j] = 1` iff there is an edge between i and j. Summing row i gives the total number of edges incident to i, which is exactly the degree.

## Complexity

- **Time:** O(N^2) — must read the entire matrix
- **Space:** O(N) for the output array
