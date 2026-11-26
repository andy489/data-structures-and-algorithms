# 203. Remove Linked List Elements — Solution

**Difficulty:** Easy  
**Link:** https://leetcode.com/problems/remove-linked-list-elements/

---

## Solution: Sentinel Node — O(n) time, O(1) space

**Idea:** Prepend a dummy (sentinel) node before the head so the head itself is handled uniformly with any other node. Traverse, skipping every node whose value equals `val`.

**Algorithm:**
1. Create `sentinel` with `sentinel.next = head`.
2. Let `curr = sentinel`.
3. While `curr.next != null`:
   - If `curr.next.val == val`, set `curr.next = curr.next.next` (skip the node).
   - Otherwise advance `curr = curr.next`.
4. Return `sentinel.next`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — only the sentinel node |
