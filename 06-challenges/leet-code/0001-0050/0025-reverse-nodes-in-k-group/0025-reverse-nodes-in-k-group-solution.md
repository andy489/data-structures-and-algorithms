# 25. Reverse Nodes in k-Group — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/reverse-nodes-in-k-group/

---

## Solution: Iterative (Dummy Head) — O(n) time, O(1) space

**Idea:** Use a dummy node before the head. For each group of `k` nodes, check there are `k` nodes remaining, then reverse them in-place by relinking, and advance the `prev` pointer to the tail of the just-reversed group.

**Algorithm:**
1. Create `dummy`; set `dummy.next = head` and `prev = dummy`.
2. Repeat:
   - Walk `k` steps from `prev` to find `groupTail`. If fewer than `k` nodes remain, stop.
   - Save `nextGroup = groupTail.next`.
   - Reverse the `k` nodes from `prev.next` up to and including `groupTail`.
   - Attach: `prev.next = groupTail` (now the new head of the reversed group), and set the old head's `next` to `nextGroup`.
   - Advance `prev` to the old head (now the tail of the reversed group).
3. Return `dummy.next`.

**Complexity:**

| | |
|---|---|
| Time  | O(n) — each node is visited a constant number of times |
| Space | O(1) — only a constant number of pointers |

---

## Solution 2: Recursive — O(n) time, O(n/k) space

**Idea:** Reverse the first `k` nodes, then recursively reverse the rest and attach.

**Algorithm:**
1. Check if there are at least `k` nodes; if not, return `head` as-is.
2. Reverse the first `k` nodes iteratively, keeping track of the `kth` node.
3. Recursively call for the remainder starting at the node after the `kth`.
4. Connect the reversed group's tail to the recursive result.
5. Return the new head (the `kth` node).

**Complexity:**

| | |
|---|---|
| Time  | O(n) — one recursive call per group |
| Space | O(n/k) — call stack depth equals number of groups |
