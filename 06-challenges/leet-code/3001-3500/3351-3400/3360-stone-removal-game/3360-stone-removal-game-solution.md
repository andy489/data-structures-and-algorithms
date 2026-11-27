# 3360. Stone Removal Game — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/stone-removal-game/

---

## Solution: Simulation — O(1) time, O(1) space

**Idea:** Simulate the game directly. Alice must remove 10 stones first; each subsequent player removes one fewer than the previous move. Alternate between Alice (even turns from Alice's perspective) and Bob until someone cannot move. With `n ≤ 50` the loop runs at most 10 iterations.

**Algorithm:**
1. Start with `toRemove = 10`, `aliceTurn = true`.
2. While `n >= toRemove`: subtract `toRemove` from `n`, flip turn, decrement `toRemove`.
3. When the loop exits, the current player cannot move — return `!aliceTurn` (Alice wins if it's Bob's turn that fails).

**Complexity:**

| | |
|---|---|
| Time | O(1) — at most 10 iterations (moves 10 down to 1) |
| Space | O(1) |
