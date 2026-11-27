# 1684. Count the Number of Consistent Strings — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/count-the-number-of-consistent-strings/

---

## Solution: Boolean Set / Bitmask — O(n) time, O(1) space

**Idea:** Store the allowed characters in a boolean array or bitmask. For each word, check if all its characters are in the allowed set.

**Algorithm:**
1. Build a boolean array `allowed[26]` from the `allowed` string.
2. For each word, check every character. If any character is not allowed, skip it.
3. Count the words where all characters are allowed.

**Complexity:**

| | |
|---|---|
| Time | O(n) where n = total characters in all words |
| Space | O(1) — fixed 26-element array |
