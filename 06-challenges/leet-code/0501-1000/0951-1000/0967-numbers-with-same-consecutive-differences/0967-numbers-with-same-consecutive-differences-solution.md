# 967. Numbers With Same Consecutive Differences — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/numbers-with-same-consecutive-differences/

---

## Solution: BFS/DFS from First Digit — O(2^n) time, O(2^n) space

**Idea:** Start with digits 1–9, then extend each number by appending last_digit ± k if valid.

**Complexity:**

| | |
|---|---|
| Time | O(2^n) — at most 2 choices per step |
| Space | O(2^n) — result list |
