# 1253. Reconstruct a 2 Row Binary Matrix — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/

---

## Solution: Greedy — O(n) time, O(n) space

**Idea:** First assign 1 to both rows where colsum=2. Then assign remaining 1s to rows with colsum=1 (upper first, then lower). Check validity.

**Algorithm:**
1. For colsum=2: set both rows to 1, decrement upper and lower.
2. For colsum=1: assign to whichever still needs more.
3. If upper or lower < 0 at any point, return [].

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
