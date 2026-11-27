# 2085. Count Common Words With One Occurrence

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/count-common-words-with-one-occurrence/

---

## Problem Statement

Given two string arrays `words1` and `words2`, return the number of strings that appear **exactly once** in each of `words1` and `words2`.

---

## Examples

**Example 1:**
```
Input:  words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]
Output: 2
```
Explanation: "leetcode" and "amazing" appear once in both.

**Example 2:**
```
Input:  words1 = ["b","bb","bbb"], words2 = ["bb","bbb"]
Output: 2
```

**Example 3:**
```
Input:  words1 = ["a","ab"], words2 = ["a","a","a","ab"]
Output: 1
```
Explanation: "ab" appears once in both.

---

## Constraints

- `1 <= words1.length, words2.length <= 1000`
- `1 <= words1[i].length, words2[i].length <= 30`
- `words1[i] and words2[i] contain only lowercase English letters.`
