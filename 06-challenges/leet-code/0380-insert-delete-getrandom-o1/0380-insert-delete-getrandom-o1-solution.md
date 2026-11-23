# 380. Insert Delete GetRandom O(1) — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/insert-delete-getrandom-o1/

---

## Solution: HashMap + ArrayList — O(1) average time, O(n) space

**Idea:** Store elements in a list for O(1) random access. Use a map from value to index for O(1) lookup. For removal, swap with the last element to avoid shifting.

**Algorithm:**
1. `insert(val)`: if not in map, append to list and map `val → size-1`.
2. `remove(val)`: swap `val` with the last element in list, update map for swapped element, remove last.
3. `getRandom()`: return `list[random index]`.

**Complexity:**

| | |
|---|---|
| Time | O(1) average for all operations |
| Space | O(n) |
