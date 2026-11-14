# 141. Linked List Cycle — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/linked-list-cycle/

---

## Solution: Floyd's Cycle Detection (Tortoise and Hare) — O(n) time, O(1) space

**Idea:** Use two pointers starting at `head`: `slow` advances one step at a time, `fast` advances two. If there is a cycle they will eventually meet inside it. If there is no cycle `fast` (or `fast.next`) reaches `null` first.

**Why they must meet:** Once both pointers are inside the cycle, the distance between them decreases by 1 each iteration (fast gains 1 step on slow per round). Since the cycle has finite length, the gap reaches 0 in at most `cycle_length` steps.

**Algorithm:**
1. If `head` is `null`, return `false`.
2. Initialise `slow = head`, `fast = head`.
3. While `fast != null` and `fast.next != null`:
   - `slow = slow.next`
   - `fast = fast.next.next`
   - If `slow == fast`, return `true`.
4. Return `false`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — at most O(n) steps before fast exits or they meet |
| Space | O(1) — two pointers only |
