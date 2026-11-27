# 725. Split Linked List in Parts — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/split-linked-list-in-parts/

---

## Solution: Length Calculation + Split — O(n) time, O(k) space

**Idea:** Compute total length n. Each part gets `n/k` nodes; the first `n%k` parts get one extra node. Walk through the list, cutting after the appropriate number of nodes.

**Algorithm:**
1. Count total nodes `n`.
2. `base = n / k`, `extra = n % k`.
3. For i in 0..k-1: take `base + (i < extra ? 1 : 0)` nodes; set result[i] = current head; advance and sever the connection.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(k) — result array (not counting list nodes themselves) |
