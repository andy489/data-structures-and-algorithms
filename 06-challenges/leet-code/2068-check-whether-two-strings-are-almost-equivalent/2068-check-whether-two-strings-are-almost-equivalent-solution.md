# 2068. Check Whether Two Strings Are Almost Equivalent — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent/

---

## Solution: Frequency Count — O(n) time, O(1) space

**Idea:** Count character frequencies in both strings, check all differences are ≤ 3.

**Algorithm:**
1. Count freq of each char in `word1` and `word2`.
2. For each letter, check `|freq1 - freq2| <= 3`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
