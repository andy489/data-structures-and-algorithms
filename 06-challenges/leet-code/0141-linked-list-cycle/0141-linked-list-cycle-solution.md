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

---

## Solution 2: HashSet of visited nodes — O(n) time, O(n) space

**Idea:** Walk the list and insert each node's reference into a `HashSet`. If `add` returns `false` (Java) / `in` returns `true` (Python/JS), the node was already seen — there is a cycle. If we reach `null`, there isn't.

**Algorithm:**
1. Initialise an empty `HashSet`.
2. Walk `cur` from `head`:
   - If `cur` is already in the set, return `true`.
   - Otherwise add `cur` and advance.
3. Return `false`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — stores up to n node references |

---

## Solution 3: Recursive with visited set — O(n) time, O(n) space (+ O(n) stack)

**Idea:** Same logic as Solution 2 but written recursively. The call stack replaces the explicit loop. Strictly worse than Solution 2 due to O(n) additional stack frames, and risks a stack overflow on very long lists (up to 10^4 nodes).

**Algorithm:**
1. Pass `node` and a `visited` set into a helper.
2. Base case: if `node` is `null`, return `false`.
3. If `node` is already in `visited`, return `true`.
4. Add `node` to `visited` and recurse on `node.next`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — one call per node |
| Space | O(n) — set + O(n) call stack |
