# 1616. Split Two Strings to Make Palindrome — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/split-two-strings-to-make-palindrome/

---

## Solution: Two Pointers — O(n) time, O(1) space

**Idea:** Use two pointers from both ends. For checking `aprefix + bsuffix`, start with `l = 0` from `a` and `r = n-1` from `b`. Advance both pointers as long as `a[l] == b[r]`. When they mismatch, the middle part must be a palindrome on its own — check if the remaining middle of `a` or `b` is a palindrome.

**Algorithm:**
1. Define a helper `check(a, b)` that uses two pointers `l = 0`, `r = n - 1`.
2. While `l < r` and `a[l] == b[r]`, advance both pointers.
3. When mismatch or pointers meet, check if `a[l..r]` is a palindrome OR `b[l..r]` is a palindrome.
4. Return `check(a, b) || check(b, a)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two passes of two pointers |
| Space | O(1) — no extra allocation |
