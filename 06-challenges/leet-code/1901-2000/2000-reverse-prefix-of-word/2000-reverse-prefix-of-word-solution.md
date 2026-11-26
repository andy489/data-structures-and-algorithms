# 2000. Reverse Prefix of Word — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/reverse-prefix-of-word/

---

## Solution: Simulation — O(n) time, O(n) space

**Idea:** Find the first occurrence of `ch`. Reverse the prefix up to and including that index.

**Algorithm:**
1. Find index `i` of first `ch` in `word`.
2. If not found, return `word`.
3. Return reversed `word[0..i]` + `word[i+1..]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
