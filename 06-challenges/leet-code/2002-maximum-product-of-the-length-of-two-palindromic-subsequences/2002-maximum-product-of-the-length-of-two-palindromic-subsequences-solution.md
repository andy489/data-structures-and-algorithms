# 2002. Maximum Product of the Length of Two Palindromic Subsequences — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/

---

## Solution: Bitmask Enumeration — O(3^n) time, O(2^n) space

**Idea:** With n ≤ 12, enumerate all bitmask subsets. For each subset, check if it forms a palindrome. Then enumerate complement split pairs.

**Algorithm:**
1. Precompute `isPalin[mask]` for all 2^n masks.
2. For each pair of disjoint masks (mask + complement split), maximize product of palindrome lengths.

**Complexity:**

| | |
|---|---|
| Time | O(3^n) |
| Space | O(2^n) |
