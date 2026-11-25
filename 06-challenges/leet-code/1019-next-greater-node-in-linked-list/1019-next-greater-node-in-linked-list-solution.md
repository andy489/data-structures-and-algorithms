# 1019. Next Greater Node In Linked List — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/next-greater-node-in-linked-list/

---

## Solution: Monotonic Stack — O(n) time, O(n) space

**Idea:** Convert list to array. Use a decreasing monotonic stack of indices. When we find a larger element, it's the next greater for all stack elements smaller than it.

**Algorithm:**
1. Flatten list to array.
2. For each i: while stack not empty and arr[stack.top] < arr[i]: ans[stack.pop()] = arr[i]; push i.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
