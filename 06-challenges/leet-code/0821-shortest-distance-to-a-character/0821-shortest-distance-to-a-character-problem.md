# 821. Shortest Distance to a Character

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/shortest-distance-to-a-character/

---

## Problem Statement

Given a string `s` and a character `c` that occurs in `s`, return an array of integers `answer` where `answer[i]` is the distance from index `i` to the closest occurrence of `c` in `s`.

---

## Examples

**Example 1:**
```
Input:  s = "loveleetcode", c = "e"
Output: [3,2,1,0,1,0,0,1,2,2,1,0]
```

---

## Constraints

- `1 <= s.length <= 10^4`
- `s[i]` and `c` are lowercase English letters.
- `c` occurs at least once in `s`.
