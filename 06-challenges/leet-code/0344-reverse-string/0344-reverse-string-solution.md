# 344. Reverse String — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/reverse-string/

---

## Solution: Two Pointers — O(n) time, O(1) space

**Idea:** Swap characters from both ends moving inward until pointers meet.

**Algorithm:**
1. `left = 0`, `right = s.length - 1`.
2. While `left < right`: swap `s[left]` and `s[right]`, then `left++`, `right--`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
