# 1021. Remove Outermost Parentheses — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/remove-outermost-parentheses/

---

## Solution: Depth Counter — O(n) time, O(n) space

**Idea:** Track depth. Add character only when depth > 0 (opening) or depth > 1 (closing). Increment depth on '(', decrement on ')'.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — output |
