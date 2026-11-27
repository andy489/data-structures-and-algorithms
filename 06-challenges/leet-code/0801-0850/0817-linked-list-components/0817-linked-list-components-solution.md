# 817. Linked List Components — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/linked-list-components/

---

## Solution: Hash Set + Single Pass — O(n) time, O(m) space

**Idea:** A new component starts when we're at a node in nums whose predecessor is not in nums. Count these "starts".

**Algorithm:**
1. Put all nums in a set.
2. Walk the list; a component starts at node x in set when previous node was not in set (or x is head).
3. Count starts.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass through list |
| Space | O(m) — set of nums values |
