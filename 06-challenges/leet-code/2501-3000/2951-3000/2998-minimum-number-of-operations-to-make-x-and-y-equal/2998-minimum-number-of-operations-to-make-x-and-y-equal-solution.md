# 2998. Minimum Number of Operations to Make X and Y Equal — Solution

## Approach: BFS (Shortest Path)

Model this as a shortest path problem. Each state is a value of `x`, and each edge is one operation (+1, -1, /5, /11). We want the minimum number of steps from `x` to `y`.

BFS guarantees the shortest path in an unweighted graph. Since `x, y <= 10^4` and operations can only increase `x` by a bounded amount (at most ~10 steps past multiples before dividing makes sense), the state space is small.

Steps:
1. Use a `queue` starting from `x` with distance `0`.
2. For each state, generate neighbors:
   - `x - 1` (decrement)
   - `x + 1` (increment)
   - `x / 5` if `x % 5 == 0`
   - `x / 11` if `x % 11 == 0`
3. When we reach `y`, return the distance.
4. Use a `visited` set to avoid revisiting states. Cap the state space at a reasonable upper bound (e.g., `max(x, y) + 11`) since going too far above makes no sense.

## Complexity

| | Time | Space |
|---|---|---|
| BFS over states | O(x + y) | O(x + y) |
| **Total** | **O(x + y)** | **O(x + y)** |
