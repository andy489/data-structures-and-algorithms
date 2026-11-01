# 20. Valid Parentheses — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/valid-parentheses/

---

## Solution: Stack — O(n) time, O(n) space

**Idea:** Use a stack to track unmatched opening brackets. For each closing bracket, check whether it matches the top of the stack. If all brackets match and the stack is empty at the end, the string is valid.

**Algorithm:**
1. Iterate over each character in `s`.
2. If it is an opening bracket (`(`, `{`, `[`), push it onto the stack.
3. If it is a closing bracket, return `false` if the stack is empty or the top does not match the corresponding opener.
4. Pop the matching opener from the stack.
5. After iterating, return `true` if and only if the stack is empty.

**Complexity:**

| | |
|---|---|
| Time  | O(n) — single pass over the string |
| Space | O(n) — stack holds at most n/2 openers |
