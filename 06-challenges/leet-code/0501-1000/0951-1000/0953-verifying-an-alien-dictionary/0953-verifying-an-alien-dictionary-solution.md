# 953. Verifying an Alien Dictionary — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/verifying-an-alien-dictionary/

---

## Solution: Order Map Comparison — O(M) time, O(1) space

**Idea:** Build a rank map from `order`, then compare adjacent word pairs character by character.

**Algorithm:**
1. Build rank array from order string.
2. For each adjacent pair, find first differing character and check rank order.
3. If prefix is longer than next word, return false.

**Complexity:**

| | |
|---|---|
| Time | O(M) — M is total characters in all words |
| Space | O(1) — rank array is fixed size 26 |
