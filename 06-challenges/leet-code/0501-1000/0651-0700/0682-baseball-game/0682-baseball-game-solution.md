# 682. Baseball Game — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/baseball-game/

---

## Solution: Stack — O(n) time, O(n) space

**Idea:** Use a stack to maintain valid scores. Apply operations accordingly.

**Algorithm:**
1. For each operation: `C` → pop; `D` → push 2*top; `+` → push top + second; else push integer.
2. Return sum of stack.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — stack |
