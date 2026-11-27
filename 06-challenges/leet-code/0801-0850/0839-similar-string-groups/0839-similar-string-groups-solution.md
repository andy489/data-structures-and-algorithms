# 839. Similar String Groups — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/similar-string-groups/

---

## Solution: Union-Find — O(n²·L) time, O(n) space

**Idea:** Two strings are similar if they differ in exactly 0 or 2 positions. Union similar pairs; count connected components.

**Algorithm:**
1. For each pair (i, j), check if similar (0 or 2 differing positions).
2. If similar, union them in Union-Find.
3. Count distinct roots.

**Complexity:**

| | |
|---|---|
| Time | O(n²·L) — n² pairs, L comparison each |
| Space | O(n) — Union-Find array |
