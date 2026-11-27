# 1816. Truncate Sentence — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/truncate-sentence/

---

## Solution: Split and Join — O(n) time, O(n) space

**Idea:** Split the sentence into words, take the first `k`, and rejoin them with spaces.

**Algorithm:**
1. Split `s` on spaces to get a word array.
2. Iterate over the first `k` words, appending each to a `StringBuilder` with a space separator.
3. Return the built string.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single split and join over all characters |
| Space | O(n) — word array and string builder |
