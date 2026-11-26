# 1408. String Matching In An Array — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/string-matching-in-an-array/

---

## Solution: Brute Force — O(n^2 * L) time, O(n) space

**Idea:** For each word, check if it appears as a substring in any other word.

**Algorithm:**
1. For each pair (w1, w2) where w1 ≠ w2: if w1 is a substring of w2, add w1 to result.
2. Return unique results.

**Complexity:**

| | |
|---|---|
| Time | O(n^2 * L) |
| Space | O(n) |
