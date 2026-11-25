# 679. 24 Game — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/24-game/

---

## Solution: Backtracking — O(1) time, O(1) space

**Idea:** Try all permutations of the 4 numbers and all combinations of operators. At each step, pick two numbers, apply an operation, and recurse with the remaining numbers.

**Algorithm:**
1. Base: if one number left, check if it equals 24 (within epsilon).
2. Try all pairs (i, j): compute all 4 operations (a+b, a-b, b-a, a*b, a/b, b/a), recurse with remaining numbers + result.

**Complexity:**

| | |
|---|---|
| Time | O(1) — bounded by constant (4! × 4³ combinations) |
| Space | O(1) — fixed depth recursion |
