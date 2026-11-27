# 1177. Can Make Palindrome from Substring

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/can-make-palindrome-from-substring/

---

## Problem Statement

Given a string `s`, you are asked to answer `q` queries. Each query is represented as a triplet `[left, right, k]`.

We may rearrange the substring `s[left..right]` and replace at most `k` characters with any lowercase letter. Return `true` for each query if it is possible to rearrange the substring to form a palindrome after at most `k` replacements, or `false` otherwise.

---

## Examples

**Example 1:**
```
Input:  s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
Output: [true,false,false,true,true]
```

**Example 2:**
```
Input:  s = "lyb", queries = [[0,1,0],[2,2,1]]
Output: [false,true]
```

---

## Constraints

- `1 <= s.length, queries.length <= 10^5`
- `0 <= left <= right < s.length`
- `0 <= k <= s.length`
- `s` consists of lowercase English letters
