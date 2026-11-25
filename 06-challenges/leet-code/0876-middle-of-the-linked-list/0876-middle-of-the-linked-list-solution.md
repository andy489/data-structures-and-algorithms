# 876. Middle of the Linked List — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/middle-of-the-linked-list/

---

## Solution: Fast/Slow Pointers — O(n) time, O(1) space

**Idea:** Slow pointer advances 1 step, fast pointer advances 2. When fast reaches end, slow is at the middle.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
