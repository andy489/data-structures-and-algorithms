# 942. DI String Match — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/di-string-match/

---

## Solution: Greedy (Low/High Pointers) — O(n) time, O(1) space

**Idea:** For 'I', assign the current lowest available number (guaranteed smaller than future). For 'D', assign the current highest. At the end, one value remains for the last position.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) extra |
