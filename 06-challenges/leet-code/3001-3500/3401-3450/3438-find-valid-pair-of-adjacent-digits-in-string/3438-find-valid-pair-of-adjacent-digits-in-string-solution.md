# 3438. Find Valid Pair of Adjacent Digits in String — Solution

## Approach

1. Count the frequency of each digit in the string.
2. Iterate through consecutive pairs `(s[i], s[i+1])`.
3. For each pair, check:
   - `s[i] != s[i+1]`
   - `freq[s[i]] == s[i] - '0'` (digit value equals its count)
   - `freq[s[i+1]] == s[i+1] - '0'` (digit value equals its count)
4. Return the first valid pair found, or empty string if none.

**Time Complexity:** O(n)
**Space Complexity:** O(1) — only 9 possible digit frequencies
