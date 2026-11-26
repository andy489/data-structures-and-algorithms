# 1748. Sum of Unique Elements — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/sum-of-unique-elements/

---

## Solution: Frequency Count — O(n) time, O(n) space

**Idea:** Count frequencies, then sum elements whose frequency is exactly 1.

**Algorithm:**
1. Build a frequency map.
2. Sum all keys with frequency 1.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two passes |
| Space | O(n) — frequency map |
