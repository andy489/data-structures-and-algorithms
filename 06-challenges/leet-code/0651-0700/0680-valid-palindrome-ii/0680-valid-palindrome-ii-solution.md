# 680. Valid Palindrome II — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/valid-palindrome-ii/

---

## Solution: Two Pointers — O(n) time, O(1) space

**Idea:** Use two pointers from both ends. On mismatch, try skipping left or right character and check if remaining substring is palindrome.

**Algorithm:**
1. `lo=0, hi=n-1`.
2. While `lo < hi`: if `s[lo] == s[hi]`, advance both. Else check `isPalin(lo+1, hi) || isPalin(lo, hi-1)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
