# 282. Expression Add Operators — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/expression-add-operators/

---

## Solution: Backtracking with Multiplication Tracking — O(4^n · n) time, O(n) space

**Idea:** Backtrack over all ways to split `num` into operands, trying `+`, `-`, `*` between them. Track the running `eval` and the last `mult` term to handle multiplication precedence: when we multiply, we undo the last addition/subtraction and re-add `mult * cur`.

**Algorithm:**
1. For each position `i` from `pos` to `n-1`, extract digit(s) `cur` (skipping multi-digit numbers with leading zeros).
2. At the first position, recurse with `cur` as the starting value and `mult = cur`.
3. For subsequent positions, try three operators:
   - `+`: `eval + cur`, `mult = cur`
   - `-`: `eval - cur`, `mult = -cur`
   - `*`: `eval - mult + mult * cur`, `mult = mult * cur`
4. When the whole string is consumed and `eval == target`, add the expression to results.

**Complexity:**

| | |
|---|---|
| Time | O(4^n · n) — 3 operator choices per position, string concatenation |
| Space | O(n) — recursion depth and expression buffer |
