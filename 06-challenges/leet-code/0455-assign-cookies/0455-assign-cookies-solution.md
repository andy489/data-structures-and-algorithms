# 455. Assign Cookies — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/assign-cookies/

---

## Solution: Greedy (Sort Both) — O(n log n) time, O(1) space

**Idea:** Sort both arrays. Try to satisfy the least greedy child with the smallest cookie that works. Use two pointers.

**Algorithm:**
1. Sort `g` (greed factors) and `s` (cookie sizes).
2. Pointer `i` over `g`, pointer `j` over `s`. If `s[j] >= g[i]`, content one more child (advance `i`). Always advance `j`.
3. Return `i` (number of content children).

**Complexity:**

| | |
|---|---|
| Time | O(n log n + m log m) — sorting both arrays |
| Space | O(1) |
