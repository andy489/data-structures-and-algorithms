# 1684. Count the Number of Consistent Strings

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/count-the-number-of-consistent-strings/

---

## Problem Statement

You are given a string `allowed` consisting of **distinct** characters and an array of strings `words`. A string is **consistent** if all characters in the string appear in the string `allowed`.

Return the **number of consistent** strings in the array `words`.

---

## Examples

**Example 1:**
```
Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
```

**Example 2:**
```
Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
Output: 7
```

**Example 3:**
```
Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
Output: 4
```

---

## Constraints

- `1 <= words.length <= 10^4`
- `1 <= allowed.length <= 26`
- `1 <= words[i].length <= 10`
- The characters in `allowed` are **distinct**.
- `words[i]` and `allowed` contain only lowercase English letters.
