# 925. Long Pressed Name — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/long-pressed-name/

---

## Solution: Two Pointers — O(n) time, O(1) space

**Idea:** Use two pointers over name and typed. If characters match, advance both. If typed has a repeat of the last name char, skip it. Otherwise return false.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
