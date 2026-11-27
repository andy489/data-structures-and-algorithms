# 756. Pyramid Transition Matrix — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/pyramid-transition-matrix/

---

## Solution: DFS with Memoization — O(7^n) time, O(7^n) space

**Idea:** Recursively build each row from the current row using the allowed map. For each pair of adjacent characters, look up all possible characters that can go on top. Use memoization on `(current_row, next_row_built_so_far)`.

**Algorithm:**
1. Build map `allowed[AB] = [C1, C2, ...]`.
2. DFS: given current row, build next row by trying all options for each adjacent pair.
3. Base case: row of length 1 → true.
4. Memoize `(cur, next)` pairs.

**Complexity:**

| | |
|---|---|
| Time | O(7^n) — bounded by possible row combinations |
| Space | O(7^n) — memo table |
