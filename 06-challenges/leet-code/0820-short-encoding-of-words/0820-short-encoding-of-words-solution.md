# 820. Short Encoding of Words — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/short-encoding-of-words/

---

## Solution: Suffix Set — O(Σ|w|²) time, O(Σ|w|) space

**Idea:** A word is redundant if it is a suffix of another word. Remove all such words. The answer is the sum of (remaining word lengths + 1).

**Algorithm:**
1. Put all words in a set.
2. For each word, remove all proper suffixes from the set.
3. Sum lengths of remaining words + 1 each.

**Complexity:**

| | |
|---|---|
| Time | O(Σ|w|²) — for each word, check all suffixes |
| Space | O(Σ|w|) — set of words |
