# 318. Maximum Product of Word Lengths — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-product-of-word-lengths/

---

## Solution: Bitmask — O(n^2 + n*L) time, O(n) space

**Idea:** Represent each word as a 26-bit integer where bit `i` is set if the word contains letter `'a'+i`. Two words share no letters iff `mask[i] & mask[j] == 0`. Then try all pairs.

**Algorithm:**
1. For each word, compute its bitmask.
2. For all pairs `(i, j)` where `mask[i] & mask[j] == 0`, track `max(len[i] * len[j])`.

**Complexity:**

| | |
|---|---|
| Time | O(n*L + n^2) — L is max word length |
| Space | O(n) — mask array |
