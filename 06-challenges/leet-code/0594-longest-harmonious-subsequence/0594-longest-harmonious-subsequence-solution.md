# 594. Longest Harmonious Subsequence — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/longest-harmonious-subsequence/

---

## Solution: HashMap Frequency Count — O(n) time, O(n) space

**Idea:** Count frequency of each number. For each number `x`, the longest harmonious subsequence containing `x` and `x+1` has length `count[x] + count[x+1]`. Take the max over all `x`.

**Algorithm:**
1. Build frequency map.
2. For each key `x` in map, if `x+1` also in map, candidate = `freq[x] + freq[x+1]`.
3. Return max candidate (0 if none).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
