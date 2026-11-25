# 706. Design HashMap — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/design-hashmap/

---

## Solution: Array of Linked Lists (Chaining) — O(n/b) avg per op, O(n+b) space

**Idea:** Same chaining approach as Design HashSet, but each bucket stores `(key, value)` pairs.

**Algorithm:**
1. Initialize `b = 769` buckets, each an empty list of `[key, value]` pairs.
2. `put(key, val)`: hash to bucket, update if key exists, else append.
3. `get(key)`: hash to bucket, scan for key, return value or -1.
4. `remove(key)`: hash to bucket, remove the pair with matching key.

**Complexity:**

| | |
|---|---|
| Time | O(n/b) average per operation |
| Space | O(n + b) |
