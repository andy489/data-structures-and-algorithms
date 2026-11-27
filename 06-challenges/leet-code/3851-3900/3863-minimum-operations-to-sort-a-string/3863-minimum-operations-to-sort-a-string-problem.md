# 3863. Minimum Operations to Sort a String

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/minimum-operations-to-sort-a-string/

## Problem

You are given a string `s` consisting of lowercase English letters.

In one operation, you can select any substring of `s` that is **not** the entire string and sort it in non-descending alphabetical order.

Return the minimum number of operations required to make `s` sorted in non-descending order. If it is not possible, return `-1`.

## Examples

**Example 1:**
```
Input: s = "dog"
Output: 1
Explanation: Sort substring "og" to "go". Now s = "dgo", which is sorted.
```

**Example 2:**
```
Input: s = "card"
Output: 2
Explanation:
- Sort "car" to "acr", so s = "acrd".
- Sort "rd" to "dr", making s = "acdr".
```

**Example 3:**
```
Input: s = "gf"
Output: -1
Explanation: It is impossible to sort s under the given constraints.
```

## Constraints

- `1 <= s.length <= 10^5`
- `s` consists of only lowercase English letters.
