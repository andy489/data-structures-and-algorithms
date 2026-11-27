# 1446. Consecutive Characters — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/consecutive-characters/

---

## Solution: Linear Scan — O(n) time, O(1) space

**Idea:** Track current run length and max run length.

**Algorithm:**
1. Scan: if s[i] == s[i-1], increment run; else reset to 1. Track max.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
