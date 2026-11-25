# 705. Design HashSet — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/design-hashset/

---

## Solution: Array of Linked Lists (Chaining) — O(n/b) avg, O(1) amortized

**Idea:** Use an array of `b` buckets where each bucket is a linked list. Hash a key to `key % b`. Use a prime number for `b` to minimize collisions.

**Algorithm:**
1. Initialize `b = 769` (prime) buckets, each an empty list.
2. `add(key)`: hash to bucket, add if not present.
3. `remove(key)`: hash to bucket, remove if present.
4. `contains(key)`: hash to bucket, check presence.

**Complexity:**

| | |
|---|---|
| Time | O(n/b) average per operation (n = total keys, b = bucket count) |
| Space | O(n + b) |
