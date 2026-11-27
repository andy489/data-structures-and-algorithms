# 752. Open the Lock — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/open-the-lock/

---

## Solution: BFS — O(10^4 · 8) time, O(10^4) space

**Idea:** BFS from `"0000"`. Each state has 8 neighbors (4 wheels × 2 directions). Stop when target is reached. Skip deadends and already-visited states.

**Algorithm:**
1. Put all deadends in a set.
2. BFS from `"0000"` with steps=0.
3. For each state, generate 8 neighbors by rotating each digit ±1 (mod 10).
4. Return steps when target found, -1 if queue exhausted.

**Complexity:**

| | |
|---|---|
| Time | O(10^4) — 10000 possible states × 8 transitions |
| Space | O(10^4) — visited set + queue |
