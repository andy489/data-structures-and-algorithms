# 1957. Delete Characters to Make Fancy String

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/delete-characters-to-make-fancy-string/

## Description

A fancy string is a string where no three consecutive characters are equal.

Given a string s, delete the minimum possible number of characters from s to make it fancy.

Return the final string after the deletion. It can be shown that the answer will always be unique.

## Examples

**Example 1:**
```
Input: s = "leeetcode"
Output: "leetcode"
Explanation: Remove an 'e' from the first group of 'e's to create "leetcode".
```

**Example 2:**
```
Input: s = "aaabaaaa"
Output: "aabaa"
```

**Example 3:**
```
Input: s = "aab"
Output: "aab"
```

## Constraints

- 1 <= s.length <= 10^5
- s consists only of lowercase English letters.
