# 1249. Minimum Remove to Make Valid Parentheses — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

---

## Solution: Stack — O(n) time, O(n) space

**Idea:** Use a stack of unmatched '(' indices. Mark unmatched parentheses for removal.

**Algorithm:**
1. Push index on '(', pop on matching ')'. If ')' with empty stack, mark it.
2. After scan, mark remaining indices in stack.
3. Build result skipping marked indices.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
