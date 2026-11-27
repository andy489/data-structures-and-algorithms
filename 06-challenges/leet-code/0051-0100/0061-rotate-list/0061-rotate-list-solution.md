# 61. Rotate List — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/rotate-list/

---

## Solution: Make Circular, Then Break — O(n) time, O(1) space

**Idea:** Find the length `n` and the tail node. Normalize `k %= n`. The new tail is at position `n - k - 1` from the head (0-indexed). Connect the old tail to the head to form a cycle, then break at the new tail.

**Algorithm:**
1. Handle empty list or `k == 0` edge cases.
2. Traverse to find `len` and `tail`.
3. `k %= len`; if `k == 0` return `head`.
4. Walk `len - k - 1` steps from head to find new tail (`newTail`).
5. Set `newHead = newTail.next`, `newTail.next = null`, `tail.next = head`.
6. Return `newHead`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two passes at most |
| Space | O(1) — pointer manipulation only |
