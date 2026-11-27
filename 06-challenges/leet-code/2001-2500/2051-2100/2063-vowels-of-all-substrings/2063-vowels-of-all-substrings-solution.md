# 2063. Vowels of All Substrings — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/vowels-of-all-substrings/

---

## Solution: Contribution Count — O(n) time, O(1) space

**Idea:** For each vowel at index i, it contributes to (i+1) * (n-i) substrings.

**Algorithm:**
1. For each index i (0-indexed), if vowel: add (i+1) * (n-i) to result.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
