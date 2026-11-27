# 488. Zuma Game — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/zuma-game/

---

## Solution: BFS/DFS with Memoization — O(board! · hand!) time, O(board · hand) space

**Idea:** Use DFS with a hand frequency map. At each step, try inserting balls of each color into consecutive groups on the board. After each insertion, repeatedly collapse groups of 3+ and recurse. Memoize by (board, hand_state).

**Algorithm:**
1. Count hand ball frequencies.
2. Build helper `collapse(board)` that removes all runs of 3+ repeatedly.
3. DFS: for each contiguous group of the same color in board, if we have enough balls to extend it to 3, do so and recurse on the collapsed result.
4. Return minimum insertions across all branches; -1 if none clear the board.

**Complexity:**

| | |
|---|---|
| Time | O(board! · hand!) — exponential but bounded by tiny constraints (board≤16, hand≤5) |
| Space | O(board · hand) — recursion + memoization |
