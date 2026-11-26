# 866. Prime Palindrome — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/prime-palindrome/

---

## Solution: Generate Odd-Length Palindromes — O(10^(d/2) * sqrt(10^d)) time, O(1) space

**Idea:** All even-length palindromes ≥ 4 are divisible by 11, so the only even prime palindrome is 11. For odd lengths, generate palindromes by mirroring half. Check primality.

**Algorithm:**
1. Handle special cases n ≤ 11.
2. For each odd length from 1,3,5,...: generate palindromes of that length from the first half. Check if ≥ n and prime.
3. Return first match.

**Complexity:**

| | |
|---|---|
| Time | O(10^(d/2) * sqrt(10^d)) per length |
| Space | O(1) |
