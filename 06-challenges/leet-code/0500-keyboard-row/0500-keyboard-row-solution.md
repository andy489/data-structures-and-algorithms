# 500. Keyboard Row — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/keyboard-row/

---

## Solution: Set Intersection — O(n · w) time, O(1) space

**Idea:** Assign each letter to its row (1, 2, or 3). A word is valid if all its letters belong to the same row.

**Algorithm:**
1. Build a char-to-row map for all 26 letters.
2. For each word, check that all characters map to the same row number.
3. Collect valid words.

**Complexity:**

| | |
|---|---|
| Time | O(n · w) — n words each of length w |
| Space | O(1) — fixed 26-char row map |
