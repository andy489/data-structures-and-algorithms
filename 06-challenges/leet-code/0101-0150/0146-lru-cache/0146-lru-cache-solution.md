# 146. LRU Cache — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/lru-cache/

---

## Solution 1: HashMap + Doubly-Linked List — O(1) time, O(n) space

**Idea:** Combine a `HashMap<key → Node>` for O(1) lookup with a doubly-linked list to track recency order. The list head is the most-recently used; the tail is the least-recently used. On every `get` or `put`, move the accessed node to the head. On eviction, remove the tail node.

Use two sentinel nodes (`head` and `tail`) to avoid null checks on boundary operations.

**Algorithm:**

`get(key)`:
1. If key not in map, return -1.
2. Move the node to the front (remove + add after head).
3. Return node's value.

`put(key, value)`:
1. If key exists: update value, move to front.
2. Else: create new node, add after head, insert into map.
3. If `size > capacity`: remove the node just before `tail`, delete from map.

**Complexity:**

| | |
|---|---|
| Time | O(1) — all operations are HashMap lookup + constant-time list pointer updates |
| Space | O(n) — n = capacity |

---

## Solution 2: LinkedHashMap (Java built-in) — O(1) amortised, O(n) space

**Idea:** Java's `LinkedHashMap` with `accessOrder = true` maintains insertion/access order automatically. Override `removeEldestEntry` to evict when over capacity.

**Complexity:**

| | |
|---|---|
| Time | O(1) amortised |
| Space | O(n) |
