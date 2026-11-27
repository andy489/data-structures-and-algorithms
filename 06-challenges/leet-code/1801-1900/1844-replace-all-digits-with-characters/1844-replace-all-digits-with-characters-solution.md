# 1844. Replace All Digits with Characters — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/replace-all-digits-with-characters/

---

## Solution: Linear Scan — O(n) time, O(n) space

**Idea:** Iterate through the string. At every odd index `i`, replace `s[i]` with `(char)(s[i-1] + (s[i] - '0'))`. All even indices remain unchanged.

**Algorithm:**
1. Convert `s` to a char array.
2. For each odd index `i`: set `arr[i] = (char)(arr[i-1] + (arr[i] - '0'))`.
3. Return the resulting string.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — output char array |
