# 830. Positions of Large Groups — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/positions-of-large-groups/

---

## Solution: Linear Scan — O(n) time, O(1) space

**Idea:** Track start of current group. When character changes, check if group size ≥ 3.

**Algorithm:**
1. Walk through s, tracking start of current group.
2. When character changes, check length; if ≥ 3, add [start, i-1] to result.
3. Handle last group after loop.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — excluding output |
