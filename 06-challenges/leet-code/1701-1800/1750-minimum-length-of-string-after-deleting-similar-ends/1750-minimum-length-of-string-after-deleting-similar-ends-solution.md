# 1750. Minimum Length of String After Deleting Similar Ends — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/

---

## Solution: Two Pointers — O(n) time, O(1) space

**Idea:** Use two pointers `l` and `r`. When `s[l] == s[r]`, advance both pointers inward past all characters equal to that character (consuming the maximal prefix and suffix). Repeat until pointers cross or characters differ.

**Algorithm:**
1. Set `l = 0`, `r = n - 1`.
2. While `l < r` and `s[l] == s[r]`, advance `l` right and `r` left past all equal chars.
3. Return `max(0, r - l + 1)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each character visited at most once |
| Space | O(1) |
