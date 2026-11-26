# 1209. Remove All Adjacent Duplicates in String II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

---

## Solution: Stack — O(n) time, O(n) space

**Idea:** Use a stack of (character, count) pairs. When the top count reaches k, pop it.

**Algorithm:**
1. Push each character with count 1.
2. If top char equals current, increment count.
3. If count reaches k, pop.
4. Rebuild string from stack.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
