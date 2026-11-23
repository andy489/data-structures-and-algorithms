# 385. Mini Parser — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/mini-parser/

---

## Solution: Stack — O(n) time, O(n) space

**Idea:** Use a stack of `NestedInteger`s. Push a new list on `[`. On `]` or `,`, parse any pending integer and add it. On `]`, pop the finished list and add it to the parent.

**Algorithm:**
1. If no brackets, return `NestedInteger(parseInt(s))`.
2. Push a sentinel empty list onto stack.
3. Walk string: on `[` push new list; on `]` or `,` flush pending number; on `]` also pop and add to parent.
4. Return stack top's single child.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — stack depth |
