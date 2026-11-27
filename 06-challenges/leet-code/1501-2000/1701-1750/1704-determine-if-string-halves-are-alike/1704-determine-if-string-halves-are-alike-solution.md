# 1704. Determine if String Halves Are Alike — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/determine-if-string-halves-are-alike/

---

## Solution: Two-Pointer Count — O(n) time, O(1) space

**Idea:** Count vowels in the first half and second half. If they're equal, return true.

**Algorithm:**
1. Use a set of vowels for O(1) lookup.
2. Count vowels in `s[0..n/2)` and `s[n/2..n)`.
3. Return whether the counts are equal.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — fixed vowel set |
