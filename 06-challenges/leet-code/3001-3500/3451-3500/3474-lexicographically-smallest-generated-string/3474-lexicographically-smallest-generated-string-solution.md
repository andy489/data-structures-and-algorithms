# 3474. Lexicographically Smallest Generated String — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/lexicographically-smallest-generated-string/

---

## Solution: Greedy + KMP — O(n*m) time, O(n+m) space

**Idea:** First, force all 'T' positions by writing `str2` into the result. Then, for all 'F' positions, verify the window is not equal to `str2`; if it is, change the last character to `str2[m-1] + 1` (lexicographically). To check equality efficiently, use KMP or Z-function. Finally, verify consistency for all 'T' positions again.

**Algorithm:**
1. Initialize result of length `n + m - 1` filled with `'a'`.
2. For each `i` where `str1[i] == 'T'`, stamp `str2` at position `i`, failing if conflict arises.
3. After stamping, for each `i` where `str1[i] == 'F'`, check if window `[i, i+m-1]` equals `str2`; if so, increment `word[i+m-1]`.
4. Validate all 'T' windows still match `str2`; return `""` on conflict.

**Complexity:**

| | |
|---|---|
| Time | O(n*m) |
| Space | O(n+m) |
