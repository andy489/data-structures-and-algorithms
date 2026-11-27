# 2047. Number of Valid Words in a Sentence — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/number-of-valid-words-in-a-sentence/

---

## Solution: Regex / Manual Parse — O(n) time, O(n) space

**Idea:** Split on whitespace, validate each token against the rules.

**Algorithm:**
1. Split sentence.
2. For each token: check no digit, at most one hyphen between letters, punct only at end.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
