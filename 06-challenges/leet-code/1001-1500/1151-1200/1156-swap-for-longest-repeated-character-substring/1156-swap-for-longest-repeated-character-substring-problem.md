# 1156. Swap For Longest Repeated Character Substring

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/swap-for-longest-repeated-character-substring/

---

## Problem Statement

Given a string `text`, you can swap two of the characters in the `text` once. Return the length of the longest substring with repeated characters.

---

## Examples

**Example 1:**
```
Input:  text = "ababa"
Output: 3
Explanation: Swap text[0] with text[1] to get "baaba", or swap text[0] with text[4] to get "bbaaa".
             The longest substring of a single character is 3.
```

**Example 2:**
```
Input:  text = "aaabaaa"
Output: 6
Explanation: Swap text[3] with text[6] to get "aaaaaab". The longest is "aaaaaa" with length 6.
```

**Example 3:**
```
Input:  text = "aaaaa"
Output: 5
Explanation: No swap needed.
```

---

## Constraints

- `1 <= text.length <= 20000`
- `text` consists of lowercase English characters only
