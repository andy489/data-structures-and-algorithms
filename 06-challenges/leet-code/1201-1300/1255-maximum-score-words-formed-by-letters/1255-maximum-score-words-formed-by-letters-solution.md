# 1255. Maximum Score Words Formed by Letters — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-score-words-formed-by-letters/

---

## Solution: Bitmask Enumeration — O(2^n * L) time, O(26) space

**Idea:** Enumerate all 2^n subsets of words. For each subset, check if the letters are sufficient and compute the score.

**Algorithm:**
1. Count available letters.
2. For each bitmask subset: count required letters.
3. If sufficient, compute score and update maximum.

**Complexity:**

| | |
|---|---|
| Time | O(2^n * L) |
| Space | O(26) |
