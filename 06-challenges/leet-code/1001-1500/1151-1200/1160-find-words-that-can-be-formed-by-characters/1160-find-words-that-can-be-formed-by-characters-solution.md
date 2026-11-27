# 1160. Find Words That Can Be Formed by Characters — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/

---

## Solution: Frequency Count — O((n + m) × 26) time, O(26) space

**Idea:** Count character frequencies in `chars`. For each word, count its character frequencies and check that every required frequency is at most what `chars` provides.

**Algorithm:**
1. Build a frequency array of size 26 for `chars`.
2. For each word, build its frequency array.
3. If for every letter the word's count ≤ chars count, add the word's length to the result.

**Complexity:**

| | |
|---|---|
| Time | O((n + m) × 26) — n = total chars length, m = total words length |
| Space | O(26) = O(1) — fixed-size frequency arrays |
