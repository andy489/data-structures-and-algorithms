# 999. Available Captures for Rook — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/available-captures-for-rook/

---

## Solution: 4-Direction Scan — O(1) time, O(1) space

**Idea:** Find the rook, then scan in each of 4 directions until a piece or border is hit.

**Complexity:**

| | |
|---|---|
| Time | O(1) — fixed 8x8 board |
| Space | O(1) |
