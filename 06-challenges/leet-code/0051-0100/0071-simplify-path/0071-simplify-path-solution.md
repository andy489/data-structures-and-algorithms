# 71. Simplify Path — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/simplify-path/

---

## Solution: Stack — O(n) time, O(n) space

**Idea:** Split the path on `'/'` to get individual components. Use a stack to simulate directory traversal: skip empty strings and `'.'`, pop for `'..'` (if stack is non-empty), and push everything else. Reconstruct by joining the stack with `'/'` and prepending `'/'`.

**Algorithm:**
1. Split `path` by `'/'` to get components (splitting naturally handles consecutive slashes by producing empty strings).
2. For each component:
   - Skip if empty or equal to `"."`.
   - If `".."`, pop from the stack if non-empty (go up one level).
   - Otherwise push onto the stack (valid directory name, including `"..."` etc.).
3. Return `"/" + "/".join(stack)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass over all characters via split + linear stack processing |
| Space | O(n) — stack stores at most n/2 components; split output is O(n) |
