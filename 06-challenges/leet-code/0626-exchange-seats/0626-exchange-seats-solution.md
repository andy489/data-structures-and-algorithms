# 626. Exchange Seats — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/exchange-seats/

---

## Solution: CASE Expression — O(n) time, O(1) space

**Idea:** Use a CASE expression to map each id to its swapped id. Even rows get id-1, odd rows (except possibly last) get id+1. If odd row has no next row, keep same id.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single scan |
| Space | O(1) — no extra storage |
