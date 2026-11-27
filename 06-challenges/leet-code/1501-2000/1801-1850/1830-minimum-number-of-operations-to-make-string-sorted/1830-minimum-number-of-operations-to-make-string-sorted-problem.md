# 1830. Minimum Number of Operations to Make String Sorted

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-number-of-operations-to-make-string-sorted/

---

## Problem Statement

You are given a string `s` (**0-indexed**). You are asked to perform the following operation until `s` becomes sorted:

1. Find **the largest index** `i` such that `1 <= i < s.length` and `s[i] < s[i - 1]`.
2. Find **the largest index** `j` such that `i <= j < s.length` and `s[k] < s[i - 1]` for all the lower indices `k` (i.e., `i <= k <= j`).
3. Swap the two characters at indices `i - 1` and `j`.
4. **Reverse** the suffix starting at index `i`.

Return the number of operations needed to make the string sorted. Since the answer can be too large, return it **modulo** `10^9 + 7`.

---

## Examples

**Example 1:**
```
Input: s = "cba"
Output: 5
Explanation: The simulation goes as follows:
Operation 1: i=2, j=2. Swap s[1] and s[2] to get s="cab", then reverse the suffix starting at 2. Now s="cab".
Operation 2: i=1, j=2. Swap s[0] and s[2] to get s="bac", then reverse the suffix starting at 1. Now s="bca".
Operation 3: i=2, j=2. Swap s[1] and s[2] to get s="bca", then reverse the suffix starting at 2. Now s="bca".
Wait — the answer for "cba" is 5.
```

**Example 2:**
```
Input: s = "aabaa"
Output: 2
```

---

## Constraints

- `1 <= s.length <= 3000`
- `s` consists only of lowercase English letters.
