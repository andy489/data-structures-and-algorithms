# 2243. Calculate Digit Sum of a String

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/calculate-digit-sum-of-a-string/

---

## Problem Statement

You are given a string `s` consisting of digits and an integer `k`.

A **round** can be applied to `s` as follows:

- Divide `s` into **consecutive groups** of size `k` such that the first `k` characters are in the first group, the next `k` characters are in the second group, and so on. **Note** that the size of the last group can be smaller than `k`.
- **Replace** each group of `s` with a string representing the integer sum of its digits. For example, `"346"` is replaced with `"13"` because `3 + 4 + 6 = 13`.
- **Merge** consecutive groups together to form a new string. If the length of the string is greater than `k`, another round is performed.

Return `s` after all rounds have been performed.

---

## Examples

**Example 1:**
```
Input:  s = "11111222223", k = 3
Output: "135"
Explanation: Round 1: ["111","112","222","23"] → sums [3,4,6,5] → "3465"
             Round 2: ["346","5"] → sums [13,5] → "135"
             len("135") = 3 ≤ k, stop.
```

**Example 2:**
```
Input:  s = "00000000", k = 3
Output: "000"
Explanation: Round 1: ["000","000","00"] → sums [0,0,0] → "000"
             len("000") = 3 ≤ k, stop.
```

---

## Constraints

- `1 <= s.length <= 100`
- `2 <= k <= 100`
- `s` consists of digits only.
