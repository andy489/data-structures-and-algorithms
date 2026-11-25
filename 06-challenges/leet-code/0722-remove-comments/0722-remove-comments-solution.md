# 722. Remove Comments — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/remove-comments/

---

## Solution: State Machine — O(n·L) time, O(n·L) space

**Idea:** Scan character by character, tracking whether we're inside a block comment. Use a buffer for the current line's non-comment characters.

**Algorithm:**
1. Maintain `inBlock = false`, `buffer = ""`.
2. For each line:
   - If `inBlock`: look for `*/` to exit block; skip chars otherwise.
   - Else: look for `//` (stop line), `/*` (enter block), or append char to buffer.
3. If not in block and buffer non-empty, add buffer to result.

**Complexity:**

| | |
|---|---|
| Time | O(n·L) — n lines, L max length |
| Space | O(n·L) — output |
