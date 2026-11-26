# 24. Swap Nodes in Pairs — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/swap-nodes-in-pairs/

---

## Solution: Iterative (Dummy Head) — O(n) time, O(1) space

**Idea:** Use a dummy node before the head. Keep a `prev` pointer; at each step take the next two nodes, rewire their pointers to swap them, then advance `prev` by two.

**Algorithm:**
1. Create `dummy`; set `dummy.next = head` and `prev = dummy`.
2. While `prev.next` and `prev.next.next` both exist:
   - Let `first = prev.next`, `second = prev.next.next`.
   - `first.next = second.next`
   - `second.next = first`
   - `prev.next = second`
   - Advance `prev = first` (which is now two steps ahead).
3. Return `dummy.next`.

**Complexity:**

| | |
|---|---|
| Time  | O(n) — each node is visited once |
| Space | O(1) — only a constant number of pointers |

---

## Solution 2: Recursive — O(n) time, O(n) space

**Idea:** Swap the first two nodes, then recursively swap the rest and attach.

**Algorithm:**
1. Base case: if `head` is null or `head.next` is null, return `head`.
2. Let `second = head.next`.
3. `head.next = swapPairs(second.next)`.
4. `second.next = head`.
5. Return `second`.

**Complexity:**

| | |
|---|---|
| Time  | O(n) — one recursive call per pair |
| Space | O(n) — call stack depth is n/2 |
