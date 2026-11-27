# 445. Add Two Numbers II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/add-two-numbers-ii/

---

## Solution: Two Stacks — O(m+n) time, O(m+n) space

**Idea:** Push both lists onto stacks to process from least-significant digit. Pop and add with carry, prepend each result node to the front of the result list.

**Algorithm:**
1. Push all nodes of `l1` and `l2` onto separate stacks.
2. Pop from both stacks, sum digits + carry.
3. Create new node with `sum % 10`, prepend to result. Update carry.
4. After both stacks empty, if carry remains prepend a final node.

**Complexity:**

| | |
|---|---|
| Time | O(m+n) |
| Space | O(m+n) — two stacks |
