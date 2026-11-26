# 1472. Design Browser History — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/design-browser-history/

---

## Solution: List + Pointer — O(1) per op time, O(n) space

**Idea:** Use a list for history with a current index pointer. Visit truncates forward history.

**Algorithm:**
1. history = [homepage], curr = 0.
2. visit: truncate history to curr+1, append url, advance curr.
3. back: curr = max(0, curr-steps), return history[curr].
4. forward: curr = min(len-1, curr+steps), return history[curr].

**Complexity:**

| | |
|---|---|
| Time | O(1) per op |
| Space | O(n) |
