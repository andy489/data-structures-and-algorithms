# 2030. Smallest K-Length Subsequence With Occurrences of a Letter

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/smallest-k-length-subsequence-with-occurrences-of-a-letter/

---

## Problem Statement

Return the **lexicographically smallest** subsequence of `s` of length `k` that contains the letter `letter` at least `repetition` times.

---

## Examples

**Example 1:**
```
Input:  s = "leet", k = 3, letter = "e", repetition = 1
Output: "eet"
```

**Example 2:**
```
Input:  s = "leetcode", k = 4, letter = "e", repetition = 2
Output: "ecde"
```

**Example 3:**
```
Input:  s = "bb", k = 2, letter = "b", repetition = 2
Output: "bb"
```

---

## Constraints

- `1 <= repetition <= k <= s.length <= 5 * 10^4`
- `letter is a lowercase English letter`
