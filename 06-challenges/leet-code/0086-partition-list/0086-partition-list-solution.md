# 86. Partition List — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/partition-list/

---

## Solution: Two Dummy Lists — O(n) time, O(1) space

**Idea:** Create two dummy-headed lists: `less` for nodes with value `< x` and `greater` for nodes with value `>= x`. Traverse the original list once, appending each node to the appropriate list. Finally connect `less.next = greaterDummy.next` and terminate `greater.next = null` to avoid a cycle.

**Algorithm:**
1. Create `lessDummy` and `greaterDummy` sentinel nodes; set `less = lessDummy`, `greater = greaterDummy`.
2. Walk `curr` through the list:
   - If `curr.val < x`: append to `less`, advance `less`.
   - Else: append to `greater`, advance `greater`.
3. Set `greater.next = null`; set `less.next = greaterDummy.next`.
4. Return `lessDummy.next`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — only pointer variables (nodes are reused) |
