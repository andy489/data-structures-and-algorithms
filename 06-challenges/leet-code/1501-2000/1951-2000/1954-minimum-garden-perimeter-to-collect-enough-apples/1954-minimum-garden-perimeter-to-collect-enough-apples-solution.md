# 1954. Minimum Garden Perimeter to Collect Enough Apples — Solution

## Approach

For a square of half-side length n (so covering [-n, n] x [-n, n]), the total number of apples is 2 * n * (n + 1) * (2n + 1).

This is derived by summing |i| + |j| for all coordinates in the square.

**Algorithm:** Binary search for the minimum n such that 2 * n * (n + 1) * (2n + 1) >= neededApples, then return 8 * n as perimeter.

**Complexity:** O(log(neededApples^(1/3))) time, O(1) space.
