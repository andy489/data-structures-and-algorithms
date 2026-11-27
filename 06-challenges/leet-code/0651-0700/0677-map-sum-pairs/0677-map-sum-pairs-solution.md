# 677. Map Sum Pairs — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/map-sum-pairs/

---

## Solution: HashMap — O(n·L) sum time, O(n·L) space

**Idea:** Store key-value in a HashMap. For sum, iterate all keys checking prefix.

**Algorithm:**
1. `insert(key, val)`: store in map.
2. `sum(prefix)`: sum values of all keys that start with prefix.

**Complexity:**

| | |
|---|---|
| Time | O(n·L) per sum — n keys, L prefix length |
| Space | O(n·L) |
