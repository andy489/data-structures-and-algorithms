# 1544. Make the String Great — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/make-the-string-great/

---

## Solution: Stack — O(n) time, O(n) space

**Idea:** Use a stack to process characters. When the top of the stack and the current character form a bad pair (same letter, different case — ASCII difference of 32), pop the stack. Otherwise push the current character.

**Algorithm:**
1. Iterate through each character.
2. If stack is non-empty and `|top - current| == 32` (same letter, opposite case), pop the top.
3. Otherwise push current character.
4. Return the stack joined as a string.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — stack in worst case |
