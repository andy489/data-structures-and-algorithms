# 460. LFU Cache

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/lfu-cache/

---

## Problem Statement

Design and implement a data structure for a **Least Frequently Used (LFU)** cache.

Implement the `LFUCache` class:

- `LFUCache(int capacity)` Initializes the object with the `capacity` of the data structure.
- `int get(int key)` Gets the value of the `key` if the `key` exists in the cache. Otherwise, returns `-1`.
- `void put(int key, int value)` Update the value of the `key` if present, or inserts the `key` if not already present. When the cache reaches its `capacity`, it should invalidate and remove the **least frequently used** key before inserting a new item. For this problem, when there is a **tie** (i.e., two or more keys with the same frequency), the **least recently used** `key` would be invalidated.

To determine the least frequently used key, a **use counter** is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

When a key is first inserted into the cache, its **use counter** is set to `1` (due to the `put` operation). The **use counter** for a key in the cache is incremented either a `get` or `put` operation is called on it.

The functions `get` and `put` must each run in `O(1)` average time complexity.

---

## Examples

**Example 1:**
```
Input:  ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
        [[2], [1,1], [2,2], [1], [3,3], [2], [3], [4,4], [1], [3], [4]]
Output: [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
```

---

## Constraints

- `0 <= capacity <= 10^4`
- `0 <= key <= 10^5`
- `0 <= value <= 10^9`
- At most `2 * 10^5` calls will be made to `get` and `put`.
