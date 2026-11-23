# 432. All O`one Data Structure — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/all-oone-data-structure/

---

## Solution: Doubly Linked List of Buckets + HashMap — O(1) time, O(n) space

**Idea:** Maintain a doubly linked list where each node (bucket) holds all keys with the same count, ordered by count ascending. A HashMap maps each key to its bucket. The min is at the front, max at the tail.

**Algorithm:**
1. Each bucket node stores: count, set of keys, prev/next pointers.
2. `inc(key)`: move key from its current bucket to the next bucket (count+1), creating buckets as needed.
3. `dec(key)`: move key to the previous bucket (count-1); remove key if count becomes 0.
4. `getMaxKey()`: return any key from the tail bucket.
5. `getMinKey()`: return any key from the head's next bucket.

**Complexity:**

| | |
|---|---|
| Time | O(1) — all operations amortized constant |
| Space | O(n) — n distinct keys |
