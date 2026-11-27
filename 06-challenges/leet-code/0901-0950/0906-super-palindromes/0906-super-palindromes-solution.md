# 906. Super Palindromes — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/super-palindromes/

---

## Solution: Enumerate Palindrome Roots — O(W^0.5) time, O(W^0.25) space

**Idea:** Generate all palindromes up to 10^9 (square root of 10^18), square them, and check if the square is also a palindrome within [left, right].

**Algorithm:**
1. For each k (odd and even length palindromes built from 1..10^5): mirror digits to form palindrome p.
2. Compute p^2; if p^2 ∈ [left, right] and isPalindrome(p^2), count it.

**Complexity:**

| | |
|---|---|
| Time | O(10^5) — bounded enumeration |
| Space | O(1) |
