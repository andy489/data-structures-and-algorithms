# 388. Longest Absolute File Path — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-absolute-file-path/

---

## Solution: Stack of Prefix Lengths — O(n) time, O(n) space

**Idea:** Use a stack where `stack[depth]` stores the cumulative path length up to that depth. For each line, count tabs to determine depth, compute cumulative length, and update max if it's a file.

**Algorithm:**
1. Split on `\n`.
2. For each token: count leading `\t` to get `depth`, strip them for the name.
3. `stack[depth + 1] = stack[depth] + len(name) + 1` (the +1 for `/`).
4. If name contains `.`, update `maxLen = max(maxLen, stack[depth + 1] - 1)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — stack |
