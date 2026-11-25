# 720. Longest Word in Dictionary — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-word-in-dictionary/

---

## Solution: HashSet + Sort — O(n·L) time, O(n·L) space

**Idea:** Sort words by length, then lexicographically. Add each word to a set if its prefix (word[0..len-2]) is already in the set. Track the longest valid word seen.

**Algorithm:**
1. Sort `words` by (length, lexicographic order).
2. Init `seen = {""}`, `ans = ""`.
3. For each word: if `word[:-1]` is in `seen`, add word to seen; if word.length > ans.length, update ans.
4. Return ans.

**Complexity:**

| | |
|---|---|
| Time | O(n·L log n) — sorting + O(n·L) lookup |
| Space | O(n·L) — set stores all words |
