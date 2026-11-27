# 1768. Merge Strings Alternately — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/merge-strings-alternately/

---

## Solution: Two Pointer — O(n+m) time, O(n+m) space

**Idea:** Use two pointers, one for each string. Alternate appending characters from each string until one is exhausted, then append the remainder of the other.

**Algorithm:**
1. Use pointers `i` and `j` starting at 0.
2. While both are in range, append `word1[i]` then `word2[j]`, advancing both.
3. Append any remaining characters from either string.
4. Return the built string.

**Complexity:**

| | |
|---|---|
| Time | O(n+m) — single pass through both strings |
| Space | O(n+m) — output string |
