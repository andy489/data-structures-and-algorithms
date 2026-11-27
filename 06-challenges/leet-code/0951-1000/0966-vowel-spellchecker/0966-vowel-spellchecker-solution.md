# 966. Vowel Spellchecker — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/vowel-spellchecker/

---

## Solution: Three Maps — O(n+q) time, O(n) space

**Idea:** Build three lookups: exact, lowercase, and vowel-masked.

**Algorithm:**
1. Exact set for exact match.
2. Lowercase map (first occurrence) for case-insensitive match.
3. Vowel-masked map (first occurrence) for vowel-error match.
4. Query each in priority order.

**Complexity:**

| | |
|---|---|
| Time | O(n+q) |
| Space | O(n) |
