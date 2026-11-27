# 1047. Remove All Adjacent Duplicates In String — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

---

## Solution: Stack — O(n) time, O(n) space

**Idea:** Use a stack. For each character, if it matches the stack top, pop (remove pair); otherwise push.

**Algorithm:**
1. For each char in s: if stack non-empty and top == char, pop. Else push.
2. Build result from stack.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
