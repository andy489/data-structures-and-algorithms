# 1609. Even Odd Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/even-odd-tree/

---

## Solution: BFS Level-Order Traversal — O(n) time, O(n) space

**Idea:** Process nodes level by level using BFS. For each level, track the previous value and validate parity and ordering constraints. Even-indexed levels require odd values in strictly increasing order; odd-indexed levels require even values in strictly decreasing order.

**Algorithm:**
1. Initialize a queue with the root; track `evenLevel = true`.
2. For each level:
   - Set `prev` to `−∞` (even level) or `+∞` (odd level).
   - For each node, check parity and that the value is strictly greater (even level) or strictly less (odd level) than `prev`.
   - Enqueue children; flip `evenLevel`.
3. Return `true` if all levels pass.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node is visited once |
| Space | O(n) — queue holds at most one full level (up to n/2 nodes) |
