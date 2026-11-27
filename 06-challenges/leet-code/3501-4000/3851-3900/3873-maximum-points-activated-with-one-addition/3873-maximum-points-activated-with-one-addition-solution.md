# Solution: 3873. Maximum Points Activated with One Addition

## Approach

Model this as a Union-Find (DSU) problem where connected components form via shared x or y coordinates.

1. Group points by x-coordinate and by y-coordinate.
2. Use DSU to union points sharing the same x or y coordinate - they all get activated together.
3. For each connected component, record its size.
4. For each pair of components, if we place a new point that shares an x with one component and a y with another (by choosing x from one component's row and y from another component's column), we activate both components plus the new point.
5. The answer is the maximum over:
   - All single component sizes + 1 (place point to activate biggest component)
   - Sum of two components that can be "bridged" via a new point + 1

To bridge two components: pick any `xi` from component A and any `yj` from component B (or vice versa), and check that `(xi, yj)` is not already in `points`.

Since this is Hard and coordinates can be large, we track for each component: which x-columns and y-rows it uses. A new point `(x, y)` with x in component A and y in component B (A != B) connects A and B, unless `(x, y)` already exists.

We precompute for each pair of DSU roots whether they can be connected.

## Complexity

- **Time:** O(n^2) worst case for checking pairs
- **Space:** O(n)
