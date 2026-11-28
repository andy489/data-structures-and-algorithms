# 2947. Count Beautiful Substrings I — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-beautiful-substrings-i/

---

## Solution: Brute Force O(n^2) — O(n^2) time, O(1) extra space

**Idea:** Since `n <= 1000`, enumerate all O(n^2) substrings and check the two conditions: equal vowel/consonant counts, and `(vowels * consonants) % k == 0`. When both hold, the substring is beautiful.

**Algorithm:**
1. For each starting index `i`, track vowel count as we extend to index `j`.
2. Consonants = (j - i + 1) - vowels.
3. Check if vowels == consonants and vowels * consonants % k == 0.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) |
| Space | O(1) extra |
