# 1171. Remove Zero Sum Consecutive Nodes from Linked List — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/

---

## Solution: Prefix Sum HashMap (Two-Pass) — O(n) time, O(n) space

**Idea:** Use a prefix sum hash map. The key insight: if the prefix sum at two nodes is equal, the nodes strictly between them sum to zero and can be removed. We use two passes:
1. First pass: map each prefix sum to the **last** node where it occurs.
2. Second pass: for each node, if its prefix sum already points to a later node in the map, skip directly to that node's next (effectively deleting the zero-sum segment).

**Algorithm:**
1. Add a dummy head node with value 0.
2. First pass: iterate the list, build `prefixSum → node` map (overwriting so we keep the last occurrence).
3. Second pass: for each node with prefix sum `ps`, set `node.next = prefixSumMap[ps].next`.
4. Return `dummy.next`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two linear passes |
| Space | O(n) — prefix sum map |
