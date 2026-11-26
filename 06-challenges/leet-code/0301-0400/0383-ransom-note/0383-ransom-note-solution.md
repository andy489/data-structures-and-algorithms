# 383. Ransom Note — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/ransom-note/

---

## Solution: Frequency Count — O(n) time, O(1) space

**Idea:** Count letter frequencies in `magazine`. For each letter in `ransomNote`, decrement. If any goes negative, return false.

**Algorithm:**
1. Count frequencies of `magazine` in an int[26] array.
2. For each char in `ransomNote`, if `--count[c] < 0` return false.
3. Return true.

**Complexity:**

| | |
|---|---|
| Time | O(n + m) — n = ransomNote length, m = magazine length |
| Space | O(1) — fixed 26-letter array |
