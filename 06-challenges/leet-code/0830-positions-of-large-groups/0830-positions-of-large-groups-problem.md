# 830. Positions of Large Groups

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/positions-of-large-groups/

---

## Problem Statement

In a string `s` of lowercase letters, a group is a maximal substring of consecutive repeated letters. A group is called large if it has 3 or more characters. Return the intervals (start, end) of every large group sorted in increasing order by start index.

---

## Examples

**Example 1:**
```
Input:  s = "abbxxxxzzy"
Output: [[3,6]]
```

**Example 2:**
```
Input:  s = "aaa"
Output: [[0,2]]
```

---

## Constraints

- `1 <= s.length <= 1000`
- `s` consists of lowercase English letters.
