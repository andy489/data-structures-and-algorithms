# 1774. Closest Dessert Cost — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/closest-dessert-cost/

---

## Solution: Backtracking / DFS — O(n * 3^m) time, O(m) space

**Idea:** Since `m <= 10`, there are at most `3^10 = 59049` topping combinations (0, 1, or 2 of each). For each base, run a DFS over all topping combinations. Track the best cost seen.

**Algorithm:**
1. For each base cost, call `dfs(toppingIdx, currentCost)`.
2. At each step, try adding 0, 1, or 2 of the current topping and recurse.
3. Update the global best answer if `|currentCost - target|` is minimized (preferring lower cost on ties).
4. Prune: if `currentCost > target` and adding more toppings only increases cost, stop.

**Complexity:**

| | |
|---|---|
| Time | O(n * 3^m) — n bases, 3^m topping combinations |
| Space | O(m) — recursion depth |
