# 1297. Maximum Number of Occurrences of a Substring — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/

---

## Solution: Sliding Window (minSize only) — O(n * minSize) time, O(n * minSize) space

**Idea:** Optimal substrings to check have length exactly minSize (a longer substring can only appear as many times as its minSize prefix). Use a sliding window of size minSize.

**Algorithm:**
1. Slide window of exactly minSize.
2. For each window: count unique chars, track frequency in a map.
3. Only add to map if unique chars <= maxLetters.
4. Return max frequency.

**Complexity:**

| | |
|---|---|
| Time | O(n * minSize) |
| Space | O(n * minSize) |
