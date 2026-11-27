# 2109. Adding Spaces to a String

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/adding-spaces-to-a-string/

---

## Problem Statement

You are given a 0-indexed string `s` and a 0-indexed integer array `spaces` that describes the indices in the original string where spaces will be added. Each space should be inserted **before** the character at the given index.

Return the **modified string** after the spaces have been added.

---

## Examples

**Example 1:**
```
Input:  s = "LeetcodeHelpsMeLearn", spaces = [8,13,15]
Output: "Leetcode Helps Me Learn"
Explanation: Spaces are inserted before indices 8, 13, and 15.
```

**Example 2:**
```
Input:  s = "icodeinpython", spaces = [1,5,7,9]
Output: "i code in py thon"
```

**Example 3:**
```
Input:  s = "spacing", spaces = [0,1,2,3,4,5,6]
Output: " s p a c i n g"
Explanation: A space is inserted before every character.
```

---

## Constraints

- `1 <= s.length <= 3 * 10^5`
- `s` consists only of lowercase and uppercase English letters.
- `1 <= spaces.length <= 3 * 10^5`
- `0 <= spaces[i] <= s.length - 1`
- All the values of `spaces` are strictly increasing.
