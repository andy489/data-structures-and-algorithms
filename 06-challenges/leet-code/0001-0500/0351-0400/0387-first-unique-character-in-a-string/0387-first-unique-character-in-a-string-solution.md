# 387. First Unique Character in a String — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/first-unique-character-in-a-string/

---

## Solution: Frequency Count — O(n) time, O(1) space

**Idea:** Count character frequencies in one pass. In a second pass, return the first character with frequency 1.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two passes |
| Space | O(1) — fixed 26-entry array |
