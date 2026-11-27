# 1686. Stone Game VI — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/stone-game-vi/

---

## Solution: Greedy Sort by Combined Value — O(n log n) time, O(n) space

**Idea:** Each player should pick the stone that maximizes their own gain while minimizing the opponent's gain. The combined value `aliceValues[i] + bobValues[i]` measures the total "importance" of stone `i`. Sort by this combined value in descending order, then alternate picks (Alice first).

**Algorithm:**
1. Create pairs `(aliceValues[i] + bobValues[i], i)` and sort descending.
2. Alice takes odd-indexed picks (0, 2, 4...) and Bob takes even-indexed picks (1, 3, 5...).
3. Compare totals and return 1 (Alice wins), -1 (Bob wins), or 0 (draw).

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
