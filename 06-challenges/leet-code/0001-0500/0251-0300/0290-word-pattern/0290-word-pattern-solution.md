# 290. Word Pattern — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/word-pattern/

---

## Solution: Two-Way HashMap — O(n) time, O(n) space

**Idea:** Maintain two maps: `charToWord` and `wordToChar`. For each `(letter, word)` pair, verify the mapping is consistent in both directions. Any conflict or length mismatch means no bijection.

**Algorithm:**
1. Split `s` by spaces. If word count ≠ pattern length, return false.
2. For each pair `(ch, word)`:
   - If `charToWord` has `ch` mapped to a different word → false.
   - If `wordToChar` has `word` mapped to a different char → false.
   - Otherwise record both mappings.
3. Return true.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — two maps |
