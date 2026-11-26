# 2011. Final Value of Variable After Performing Operations — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/final-value-of-variable-after-performing-operations/

---

## Solution: Simulation — O(n) time, O(1) space

**Idea:** Check the `+` or `-` character in each operation string.

**Algorithm:**
1. Start X = 0.
2. For each op, if it contains '+' increment X, else decrement X.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
