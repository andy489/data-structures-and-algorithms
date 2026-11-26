# 636. Exclusive Time of Functions — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/exclusive-time-of-functions/

---

## Solution: Stack Simulation — O(n) time, O(n) space

**Idea:** Use a stack to track the current function. When a new function starts, add elapsed time to the top of stack. When a function ends, finalize its time.

**Algorithm:**
1. Parse each log into (id, type, time).
2. Maintain a stack of function ids and `prevTime`.
3. On `start`: add `time - prevTime` to stack top's time (if stack non-empty); push new id; update `prevTime`.
4. On `end`: add `time - prevTime + 1` to current function; pop stack; update `prevTime = time + 1`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — one pass through logs |
| Space | O(n) — stack depth |
