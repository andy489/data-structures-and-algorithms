# 676. Implement Magic Dictionary — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/implement-magic-dictionary/

---

## Solution: HashMap by Length + Compare — O(n·L) time, O(n·L) space

**Idea:** Store words grouped by length. For search, compare each same-length word character by character and count mismatches.

**Algorithm:**
1. `buildDict`: group words by length in a map.
2. `search`: for each word of same length, count char mismatches. Return true if any has exactly 1 mismatch.

**Complexity:**

| | |
|---|---|
| Time | O(n·L) per search — n words, L max length |
| Space | O(n·L) — storing all words |
