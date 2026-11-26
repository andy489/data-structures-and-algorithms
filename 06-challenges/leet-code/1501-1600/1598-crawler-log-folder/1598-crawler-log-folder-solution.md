# 1598. Crawler Log Folder — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/crawler-log-folder/

---

## Solution: Stack Simulation — O(n) time, O(1) space

**Idea:** Track current depth as an integer. `"../"` decreases depth (clamped at 0), `"./"` does nothing, any other operation increases depth.

**Algorithm:**
1. For each log: if `"../"`, `depth = max(0, depth - 1)`. If `"./"`, do nothing. Else `depth++`.
2. Return `depth`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass through logs |
| Space | O(1) — integer counter only |
