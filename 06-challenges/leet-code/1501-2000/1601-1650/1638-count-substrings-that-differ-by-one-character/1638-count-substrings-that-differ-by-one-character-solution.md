# 1638. Count Substrings That Differ by One Character — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-substrings-that-differ-by-one-character/

---

## Solution: Fix the Mismatch Position — O(m * n) time, O(1) space

**Idea:** For every pair of indices `(i, j)` where `s[i] != t[j]`, that mismatch becomes the single differing character. Extend outward in both directions as long as characters match to count valid substrings centered at this mismatch.

**Algorithm:**
1. For each `i` in `s` and `j` in `t` where `s[i] != t[j]`:
   - Count how far left we can go while `s` and `t` match: `left`.
   - Count how far right we can go while `s` and `t` match: `right`.
   - Each such mismatch contributes `(left + 1) * (right + 1)` pairs.
2. Sum all contributions.

**Complexity:**

| | |
|---|---|
| Time | O(m * n) — iterating all mismatch pairs and extending |
| Space | O(1) |
