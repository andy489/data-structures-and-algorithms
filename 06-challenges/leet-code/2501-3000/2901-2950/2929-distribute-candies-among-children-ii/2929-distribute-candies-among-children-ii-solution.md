# 2929. Distribute Candies Among Children II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/distribute-candies-among-children-ii/

---

## Solution: Inclusion-Exclusion — O(1) time, O(1) space

**Idea:** Count non-negative integer solutions to `x + y + z = n` with `0 <= x, y, z <= limit` using inclusion-exclusion. Without the upper bound, the count is `C(n+2, 2)`. Subtract cases where at least one variable exceeds `limit`: substituting `x' = x - (limit+1)` gives `C(n - (limit+1) + 2, 2)` cases for each of the 3 variables. Add back cases where two variables exceed `limit`, subtract the case where all three do.

A helper `comb2(x)` = `x*(x-1)/2` for `x >= 2`, else 0.

**Algorithm:**
1. Let `f(x) = C(x+2, 2)` = number of non-negative solutions to sum = x with 3 variables.
2. Total = `f(n) - 3*f(n-limit-1) + 3*f(n-2*(limit+1)) - f(n-3*(limit+1))`.
3. Return `max(0, Total)`.

**Complexity:**

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |
