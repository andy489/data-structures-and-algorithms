# 2062. Count Vowel Substrings of a String — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/count-vowel-substrings-of-a-string/

---

## Solution: Brute Force — O(n^2) time, O(1) space

**Idea:** Enumerate all substrings, check if all 5 vowels present and no consonants.

**Algorithm:**
1. For each pair `(i, j)`, check substring is all vowels and contains all 5.
2. Count valid substrings.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) |
| Space | O(1) |
