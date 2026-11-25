# 707. Design Linked List — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/design-linked-list/

---

## Solution: Singly Linked List with Sentinel Head — O(n) per indexed op, O(1) for head/tail

**Idea:** Use a sentinel (dummy) head node to simplify edge cases. Track size for validity checks. Tail pointer makes addAtTail O(1).

**Algorithm:**
1. Maintain `dummy` head node, `tail` pointer, and `size`.
2. `get(index)`: traverse from dummy.next to the index-th node.
3. `addAtHead(val)`: insert after dummy; update tail if list was empty.
4. `addAtTail(val)`: append via tail pointer; update tail.
5. `addAtIndex(index, val)`: traverse to (index-1)th node, insert after.
6. `deleteAtIndex(index)`: traverse to (index-1)th node, skip next.

**Complexity:**

| | |
|---|---|
| Time | O(n) for indexed operations, O(1) for addAtHead/addAtTail |
| Space | O(n) |
