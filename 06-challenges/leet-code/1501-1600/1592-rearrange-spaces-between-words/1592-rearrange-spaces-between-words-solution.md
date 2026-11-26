# 1592. Rearrange Spaces Between Words — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/rearrange-spaces-between-words/

---

## Solution: String Split — O(n) time, O(n) space

**Idea:** Count total spaces, extract words, divide spaces evenly across gaps between words, place remainder at the end.

**Algorithm:**
1. Count spaces in `text`.
2. Split `text` on whitespace to get `words`.
3. `gaps = words.length - 1`. `between = spaces / gaps` (or 0 if one word). `trailing = spaces - between * gaps`.
4. Join words with `between` spaces, append `trailing` spaces.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass to count + split |
| Space | O(n) — result string |
