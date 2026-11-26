# 1721. Swapping Nodes in a Linked List — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

---

## Solution: Two-Pointer — O(n) time, O(1) space

**Idea:** Find the kth node from the start, then use a second pointer lagging by k steps to find the kth from the end. Swap their values (not nodes).

**Algorithm:**
1. Walk `k-1` steps from head to reach `front` (kth from start).
2. Set `back = head` and `cur = front`. Advance both together until `cur.next == null` — now `back` is kth from end.
3. Swap `front.val` and `back.val`.
4. Return `head`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — pointer variables only |
