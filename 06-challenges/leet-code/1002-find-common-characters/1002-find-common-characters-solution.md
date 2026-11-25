# 1002. Find Common Characters — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-common-characters/

---

## Solution: Min Frequency Intersection — O(N·W) time, O(1) space

**Idea:** Compute character frequencies for each word, then take the element-wise minimum across all words. Each character appears in the result `minFreq` times.

**Algorithm:**
1. Initialize `minFreq[26]` to INT_MAX.
2. For each word, compute its frequency array and take element-wise min with `minFreq`.
3. For each character with minFreq > 0, add it that many times to the result.

**Complexity:**

| | |
|---|---|
| Time | O(N·W) — N words of average length W |
| Space | O(1) — fixed 26-element arrays |
