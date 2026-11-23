# 430. Flatten a Multilevel Doubly Linked List — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

---

## Solution: Iterative with Stack — O(n) time, O(n) space

**Idea:** Use a stack to simulate DFS pre-order traversal. When a node has a child, push the next node onto the stack and recurse into the child.

**Algorithm:**
1. Push head onto stack.
2. While stack non-empty: pop node, link to previous processed node.
3. Push `node.next` first (processed later), then `node.child` (processed next).
4. Clear `node.child`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node visited once |
| Space | O(n) — stack depth |

---

## Solution 2: Recursive — O(n) time, O(d) space

**Idea:** Recursively flatten each child list and splice it in between the current node and its next.

**Algorithm:**
1. Traverse nodes; when a child is found, recursively flatten the child list.
2. Find the tail of the flattened child list.
3. Splice: curr → child list → curr.next; clear child pointer.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node visited once |
| Space | O(d) — recursion depth where d is max depth |
