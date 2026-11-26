# 1483. Kth Ancestor Of A Tree Node — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/kth-ancestor-of-a-tree-node/

---

## Solution: Binary Lifting — O(n log n) build, O(log n) query time, O(n log n) space

**Idea:** Precompute ancestor table: dp[j][i] = 2^j-th ancestor of node i. Answer k-th ancestor by decomposing k in binary.

**Algorithm:**
1. Build dp[0][i] = parent[i]. dp[j][i] = dp[j-1][dp[j-1][i]].
2. Query(node, k): for each bit set in k, jump 2^j steps.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) build, O(log n) query |
| Space | O(n log n) |
