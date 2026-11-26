# 792. Number of Matching Subsequences — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-matching-subsequences/

---

## Solution: Waiting Buckets — O(|s| + sum of word lengths) time, O(total word chars) space

**Idea:** Maintain 26 buckets, each holding iterators of words waiting for a particular next character. For each character in `s`, advance all waiting words.

**Algorithm:**
1. Place each word (as an iterator/index) in the bucket of its first character.
2. For each character `c` in `s`: pop all waiting words from bucket `c`; advance each by one; if exhausted, increment count; else put in next character's bucket.

**Complexity:**

| | |
|---|---|
| Time | O(|s| + Σ|words[i]|) |
| Space | O(Σ|words[i]|) |
