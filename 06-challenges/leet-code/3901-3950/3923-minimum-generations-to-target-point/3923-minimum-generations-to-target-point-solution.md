# 3923. Minimum Generations to Target Point — Solution

## Approach: BFS (Breadth-First Search) over Point Sets

Since coordinates are bounded to `[0, 6]`, the total number of distinct 3D points is at most `7^3 = 343`. We use BFS where each state is the set of all known points.

At each generation (BFS level), we try all pairs of currently known points and compute their midpoints (floor division). If a new midpoint is the target, we return the current generation. If a new midpoint has not been seen before, we add it to the next generation.

Since the constraint space is tiny (all coordinates 0-6), the BFS terminates quickly. If no new points are generated and the target hasn't been found, return -1.

## Complexity

- **Time:** O(G * S^2) where G is the number of generations and S is the total set size (bounded by 343)
- **Space:** O(S) — for storing the known point set
