# 1662. Check If Two String Arrays are Equivalent — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/

---

## Solution: Join and Compare — O(n) time, O(n) space

**Idea:** Concatenate all strings in each array and compare the resulting strings.

**Algorithm:**
1. Join all strings in `word1` to get string `s1`.
2. Join all strings in `word2` to get string `s2`.
3. Return `s1.equals(s2)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) where n = total characters |
| Space | O(n) — concatenated strings |
