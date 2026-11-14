# 79. Word Search — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/word-search/

---

## Solution: Backtracking DFS — O(m·n·4^L) time, O(L) space

**Idea:** Try starting the word from every cell. From each candidate start, perform a DFS that matches characters one by one, marking cells as visited by temporarily overwriting them (restoring on backtrack). If all `L` characters match, return `true`.

**Algorithm:**
1. For each cell `(r, c)`, if `board[r][c] == word[0]`, call `dfs(r, c, 0)`.
2. In `dfs(r, c, idx)`:
   - If `idx == word.length`, return `true` (entire word matched).
   - If out of bounds, or `board[r][c] != word[idx]`, return `false`.
   - Mark cell: save `board[r][c]`, overwrite with `'#'`.
   - Recurse into all four neighbors with `idx + 1`; if any returns `true`, propagate it.
   - Unmark cell: restore `board[r][c]`.
3. Return `false` if no starting cell yields a match.

**Pruning:** Reversing the word before searching when `word[0]` is rarer than `word[L-1]` can significantly reduce branches explored.

**Complexity:**

| | |
|---|---|
| Time | O(m·n·4^L) — each cell starts a DFS branching up to 4 ways per character |
| Space | O(L) — recursion depth equals word length |
