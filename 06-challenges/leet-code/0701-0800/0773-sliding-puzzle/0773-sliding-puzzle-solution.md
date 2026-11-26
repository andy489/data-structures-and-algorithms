# 773. Sliding Puzzle — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/sliding-puzzle/

---

## Solution: BFS on State String — O(1) time, O(1) space

**Idea:** Encode the board as a 6-character string and BFS over all reachable states. The neighbors of each position in the flattened 2×3 grid are fixed.

**Algorithm:**
1. Flatten board to string; target is `"123450"`.
2. BFS: at each step, find `'0'`, swap it with each valid neighbor, enqueue new state if unseen.
3. Return steps when target reached, or -1 if queue exhausts.

**Complexity:**

| | |
|---|---|
| Time | O(1) — at most 6! = 720 states |
| Space | O(1) — bounded state space |
