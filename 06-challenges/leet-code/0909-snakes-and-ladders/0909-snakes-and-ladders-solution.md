# 909. Snakes and Ladders — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/snakes-and-ladders/

---

## Solution: BFS — O(n²) time, O(n²) space

**Idea:** BFS from square 1 to n². Convert label to board coordinates, follow snakes/ladders, track visited squares.

**Algorithm:**
1. BFS queue starts with square 1 at distance 0.
2. For each current square, try dice rolls 1–6.
3. Convert next label to `(row, col)`: `label-1` from bottom-left in boustrophedon order.
4. If board cell != -1, jump to that value. Mark visited, enqueue if not seen.
5. Return steps when n² reached.

**Complexity:**

| | |
|---|---|
| Time | O(n²) |
| Space | O(n²) |
