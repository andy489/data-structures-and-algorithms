# 2059. Minimum Operations to Convert Number — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-operations-to-convert-number/

---

## Solution: BFS — O(n * 1000) time, O(1000) space

**Idea:** BFS from start. At each step, apply each operation. Only keep values in [0,1000] (unless it's goal).

**Algorithm:**
1. BFS with visited set.
2. For each current value, try +nums[i], -nums[i], ^nums[i] for all i.
3. If result == goal, return distance.
4. Only enqueue values in [0,1000].

**Complexity:**

| | |
|---|---|
| Time | O(n * 1000) |
| Space | O(1000) |
