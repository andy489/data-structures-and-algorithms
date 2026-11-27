# 748. Shortest Completing Word — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/shortest-completing-word/

---

## Solution: Frequency Count — O(n·L) time, O(1) space

**Idea:** Count letter frequencies in the license plate (ignoring non-letters). For each word, check if its letter frequencies satisfy all requirements. Track the shortest such word.

**Algorithm:**
1. Build frequency array `need[26]` from lowercase letters of `licensePlate`.
2. For each word, build `have[26]` and check `have[c] >= need[c]` for all c.
3. Among valid words, return the first shortest.

**Complexity:**

| | |
|---|---|
| Time | O(n·L) — n words, L max length |
| Space | O(1) — fixed 26-char arrays |
