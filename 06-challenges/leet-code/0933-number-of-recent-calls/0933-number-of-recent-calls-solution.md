# 933. Number of Recent Calls — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/number-of-recent-calls/

---

## Solution: Queue — O(1) amortized per ping, O(n) space

**Idea:** Maintain a queue of timestamps. On each ping, add t, then remove all timestamps older than t-3000. Queue size is the answer.

**Complexity:**

| | |
|---|---|
| Time | O(1) amortized |
| Space | O(min(n, 3000)) |
