# 557. Reverse Words in a String III — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/reverse-words-in-a-string-iii/

---

## Solution: Per-word Reverse — O(n) time, O(n) space

**Idea:** Split by space, reverse each word, rejoin.

**Algorithm:**
1. Split `s` by `" "`.
2. For each word, reverse its characters.
3. Join with `" "`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — total characters |
| Space | O(n) — output string |
