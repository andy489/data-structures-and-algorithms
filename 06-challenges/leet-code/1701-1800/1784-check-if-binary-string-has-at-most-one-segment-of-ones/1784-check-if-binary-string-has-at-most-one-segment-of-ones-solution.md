# 1784. Check if Binary String Has at Most One Segment of Ones — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/

---

## Solution: Check for "01" Pattern — O(n) time, O(1) space

**Idea:** Since there are no leading zeros, the string starts with `1`. A second segment of ones can only appear after a zero. So there is more than one segment of ones if and only if the substring "01" appears anywhere in `s`.

**Algorithm:**
1. Check if `"01"` is a substring of `s`.
2. If yes, return `false`. Otherwise, return `true`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass substring search |
| Space | O(1) — no extra space |
