# 2108. Find First Palindromic String in the Array — Solution

**Difficulty:** Easy  
**Link:** https://leetcode.com/problems/find-first-palindromic-string-in-the-array/

---

## Solution: Two Pointers Palindrome Check — O(n * m) time, O(1) space

**Idea:** Iterate over the array. For each word, check if it is a palindrome using two pointers. Return the first palindrome found, or `""` if none exists.

**Algorithm:**
1. For each `word` in `words`:
   - Use two pointers `l = 0`, `r = word.length - 1`.
   - While `l < r`, check if `word[l] == word[r]`. If not, it's not a palindrome; break.
   - If the loop completes without mismatch, return `word`.
2. If no palindrome found, return `""`.

**Complexity:**

| | |
|---|---|
| Time | O(n * m) — n words, m = max word length |
| Space | O(1) — no extra storage |
