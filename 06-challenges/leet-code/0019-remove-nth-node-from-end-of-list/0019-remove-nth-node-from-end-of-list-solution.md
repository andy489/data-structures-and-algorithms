# 19. Remove Nth Node From End of List — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/remove-nth-node-from-end-of-list/

---

## Solution 1: Two Pointers (One Pass) — O(n) time, O(1) space

**Idea:** Place a dummy node before head to simplify edge cases (removing the head). Advance `fast` n+1 steps so that when `fast` reaches null, `slow` sits exactly on the node *before* the one to remove.

**Algorithm:**
1. Create a `dummy` node pointing to `head`; set both `slow` and `fast` to `dummy`.
2. Advance `fast` by `n + 1` steps.
3. Move both `slow` and `fast` one step at a time until `fast` is null.
4. `slow.next` is the target node — bypass it: `slow.next = slow.next.next`.
5. Return `dummy.next`.

**Complexity:**

| | |
|---|---|
| Time  | O(n) — single pass over the list |
| Space | O(1) — two pointers only |

---

## Solution 2: Recursive — O(n) time, O(n) space

**Idea:** Recurse to the end of the list. On the way back, count up; when the counter equals `n`, skip that node.

**Algorithm:**
1. Base case: if `node` is null, return 0.
2. Recurse on `node.next`; increment the returned depth by 1.
3. When depth equals `n`, set `node.next = node.next.next` and return a sentinel (e.g., -1) to stop further skips.
4. Use a dummy node so the head itself can be removed without special-casing.

**Complexity:**

| | |
|---|---|
| Time  | O(n) — full traversal down and back |
| Space | O(n) — recursion call stack |
