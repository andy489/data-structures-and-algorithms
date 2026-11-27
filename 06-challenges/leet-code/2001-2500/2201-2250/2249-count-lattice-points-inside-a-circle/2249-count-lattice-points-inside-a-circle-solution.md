# 2249. Count Lattice Points Inside a Circle — Solution

## Approach

Since `xi, yi <= 100` and `ri <= min(xi, yi)`, all relevant lattice points are in a small range. For each circle, iterate over all candidate lattice points `(x, y)` in the bounding box `[xi-ri, xi+ri] x [yi-ri, yi+ri]`. Check if the point is inside the circle using the condition `(x - xi)^2 + (y - yi)^2 <= ri^2`. Use a set to avoid counting duplicates.

## Complexity

- **Time:** O(circles.length * max_r^2)
- **Space:** O(total lattice points inside circles)
