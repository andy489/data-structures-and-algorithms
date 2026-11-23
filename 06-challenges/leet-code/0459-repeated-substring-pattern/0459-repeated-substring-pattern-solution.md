# 459. Repeated Substring Pattern — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/repeated-substring-pattern/

---

## Solution: String Rotation Trick — O(n) time, O(n) space

**Idea:** If `s` is made of repeated substrings, then `s + s` (with the first and last chars removed) will still contain `s`. This leverages KMP-style string matching.

**Algorithm:**
1. Form `doubled = (s + s).substring(1, 2*n - 1)`.
2. Return `doubled.contains(s)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — with KMP; O(n²) with naive contains |
| Space | O(n) — doubled string |

---

## Solution 2: KMP Failure Function — O(n) time, O(n) space

**Idea:** Build the KMP failure function. If the last value `lps[n-1] > 0` and `n % (n - lps[n-1]) == 0`, there is a repeated pattern.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
