# 1515. Best Position for a Service Centre — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/best-position-for-a-service-centre/

---

## Solution: Gradient Descent (Weiszfeld's Algorithm) — O(n * iterations) time, O(1) space

**Idea:** The geometric median minimizes the sum of Euclidean distances. Weiszfeld's algorithm iteratively updates the candidate point by a weighted average of all customer positions, with weights inversely proportional to their distances from the current candidate. Start from the centroid and iterate until convergence.

**Algorithm:**
1. Initialize `(x, y)` as the centroid of all positions.
2. Iterate until step size is below epsilon (1e-6):
   - Compute weights `w_i = 1 / dist(x, y, positions[i])` (skip if distance is 0).
   - `x_new = sum(w_i * xi) / sum(w_i)`, `y_new = sum(w_i * yi) / sum(w_i)`.
   - Gradually reduce step size if Weiszfeld doesn't converge (or just use shrinking step).
3. Return `sum of dist(x, y, positions[i])`.

**Complexity:**

| | |
|---|---|
| Time | O(n * iterations) — typically converges in ~1000 iterations |
| Space | O(1) — constant extra |
