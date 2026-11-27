# 1130. Minimum Cost Tree From Leaf Values — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/

---

## Solution: Monotonic Stack — O(n) time, O(n) space

**Idea:** Each non-leaf node's value equals `max(left subtree leaves) * max(right subtree leaves)`. We want to minimize the total internal node sum. Using a monotonic decreasing stack: when we find a value larger than the stack top, the top is the smallest leaf in its local context. It must be multiplied by the smaller of its two neighbors (the new element and the previous stack element). This greedy argument gives an O(n) solution.

**Algorithm:**
1. Maintain a monotonic decreasing stack. Push `INT_MAX` as a sentinel at the bottom.
2. For each element `v` in `arr`:
   - While `stack.top() <= v`, pop the top `mid`. Add `mid * min(stack.top(), v)` to the answer.
   - Push `v`.
3. After processing all elements, drain remaining stack pairs: each adjacent pair multiplies.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each element pushed/popped once |
| Space | O(n) — stack |

---

## Solution 2: Interval DP — O(n^3) time, O(n^2) space

**Idea:** `dp[i][j]` = minimum cost to build a tree from `arr[i..j]`. For each split point `k`, the cost is `dp[i][k] + dp[k+1][j] + max(arr[i..k]) * max(arr[k+1..j])`. Precompute range maxima.

**Complexity:**

| | |
|---|---|
| Time | O(n^3) |
| Space | O(n^2) |
