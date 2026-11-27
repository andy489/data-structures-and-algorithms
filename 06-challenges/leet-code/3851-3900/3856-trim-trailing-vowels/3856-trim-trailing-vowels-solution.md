# 3856. Trim Trailing Vowels — Solution

**Link:** https://leetcode.com/problems/trim-trailing-vowels/

## Approach: Scan from Right

Scan from the end of the string towards the beginning. Find the first character that is not a vowel. Return the substring from index 0 to that position (inclusive).

## Complexity

- **Time:** O(n)
- **Space:** O(1) extra (output string is O(n))
