# 1016. Binary String With Substrings Representing 1 To N — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/

---

## Solution: Check only large values — O(s.length²) time, O(1) space

**Idea:** If n is large, its binary representation is long and unlikely to fit in s. Only numbers with binary length > s.length can't appear. So only check from max(1, n - 2*s.length) to n.

**Algorithm:**
1. For i from n down to max(1, n - 2*|s|): check if binary(i) is a substring of s.
2. If any miss, return false.

**Complexity:**

| | |
|---|---|
| Time | O(\|s\|²) — at most 2*\|s\| checks, each O(\|s\|) |
| Space | O(log n) — binary string |
