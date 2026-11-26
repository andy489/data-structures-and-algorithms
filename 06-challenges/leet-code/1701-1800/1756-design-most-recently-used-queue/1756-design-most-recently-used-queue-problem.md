# 1756. Design Most Recently Used Queue

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/design-most-recently-used-queue/

---

## Problem Statement

Design a queue-like data structure that moves the most recently used element to the end of the queue.

Implement the `MRUQueue` class:

- `MRUQueue(int n)` constructs the `MRUQueue` with `n` elements: `[1, 2, 3, ..., n]`.
- `int fetch(int k)` moves the `k`th element **(1-indexed)** to the end of the queue and returns it.

---

## Examples

**Example 1:**
```
Input:
["MRUQueue", "fetch", "fetch", "fetch", "fetch"]
[[8], [3], [5], [2], [8]]
Output:
[null, 3, 6, 2, 2]

Explanation:
MRUQueue mRUQueue = new MRUQueue(8); // [1,2,3,4,5,6,7,8]
mRUQueue.fetch(3);                    // [1,2,4,5,6,7,8,3], return 3
mRUQueue.fetch(5);                    // [1,2,4,5,7,8,3,6], return 6
mRUQueue.fetch(2);                    // [1,4,5,7,8,3,6,2], return 2
mRUQueue.fetch(8);                    // [1,4,5,7,8,3,6,2], return 2
```

---

## Constraints

- `1 <= n <= 2000`
- `1 <= k <= the current size of the queue`
- At most `2000` calls will be made to `fetch`.
