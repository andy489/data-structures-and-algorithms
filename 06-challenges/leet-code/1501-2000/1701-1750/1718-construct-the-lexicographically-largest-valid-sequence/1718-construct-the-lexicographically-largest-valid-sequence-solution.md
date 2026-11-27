# 1718. Construct the Lexicographically Largest Valid Sequence — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/

---

## Solution: Backtracking — O(n!) time, O(n) space

**Idea:** Use backtracking to fill positions from left to right. At each empty position, try placing numbers from `n` down to `1` (to get lexicographically largest). For number `i > 1`, check that position `pos + i` is also empty and place `i` at both positions. For `1`, just place it once.

**Algorithm:**
1. Create result array of size `2n - 1` (1 appears once, each 2..n appears twice with gap i).
2. Use DFS: find next unfilled position, try values n down to 1.
3. For value `v`: if `v == 1`, place at current pos; if `v > 1`, place at current pos and `pos + v`.
4. Backtrack if no valid placement.

**Complexity:**

| | |
|---|---|
| Time | O(n!) in worst case, but pruning makes it very fast in practice |
| Space | O(n) — recursion depth and result array |
