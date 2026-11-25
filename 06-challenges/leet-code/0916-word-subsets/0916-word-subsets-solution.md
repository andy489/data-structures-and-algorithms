# 916. Word Subsets — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/word-subsets/

---

## Solution: Max Frequency Merge — O((A+B)×26) time, O(26) space

**Idea:** Compute the max frequency needed for each character across all words2 (a merged "super-requirement"). Then each word1 is universal iff it satisfies all requirements.

**Algorithm:**
1. For each word in words2, compute freq; update maxFreq with element-wise max.
2. For each word in words1, check if its freq ≥ maxFreq for all chars.

**Complexity:**

| | |
|---|---|
| Time | O((A+B)×26) |
| Space | O(26) |
