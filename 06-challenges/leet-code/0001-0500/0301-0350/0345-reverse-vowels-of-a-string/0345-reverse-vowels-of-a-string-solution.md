# 345. Reverse Vowels of a String — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/reverse-vowels-of-a-string/

---

## Solution: Two Pointers — O(n) time, O(n) space

**Idea:** Use two pointers from both ends. Skip non-vowels, swap vowels, and converge.

**Algorithm:**
1. Convert to char array. `left = 0`, `right = n-1`.
2. While `left < right`:
   - Advance `left` while not a vowel.
   - Retreat `right` while not a vowel.
   - If `left < right`, swap `s[left]` and `s[right]`, then `left++`, `right--`.
3. Return new string.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — char array copy |
