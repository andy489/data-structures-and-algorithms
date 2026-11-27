# 1668. Maximum Repeating Substring — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-repeating-substring/

---

## Solution: Linear Search — O(n^2 / |word|) time, O(n) space

**Idea:** Incrementally build `word` repeated `k` times and check containment. Stop when the concatenated string exceeds `sequence` length.

**Algorithm:**
1. Start with `repeated = word`.
2. While `sequence.contains(repeated)`, increment `k` and append `word`.
3. Return `k - 1` (last valid k).

**Complexity:**

| | |
|---|---|
| Time | O(n^2 / w) where n = sequence length, w = word length |
| Space | O(n) — repeated string |
