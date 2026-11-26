# 864. Shortest Path to Get All Keys — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/shortest-path-to-get-all-keys/

---

## Solution: BFS with State (Position + Keys Bitmask) — O(m*n*2^k) time, O(m*n*2^k) space

**Idea:** Encode state as (row, col, keys_bitmask). BFS from start. When picking up a key, update bitmask. When hitting a lock, check bitmask for key. Return steps when all keys collected.

**Algorithm:**
1. Find start position and count keys k.
2. BFS with state (r, c, keys). Start: (startR, startC, 0).
3. At each cell: if key → update keys in state; if lock → skip unless have key; if reached all keys → return steps.
4. Skip visited (r, c, keys) states.

**Complexity:**

| | |
|---|---|
| Time | O(m * n * 2^k) |
| Space | O(m * n * 2^k) |
