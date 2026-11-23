# 381. Insert Delete GetRandom O(1) - Duplicates allowed — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/

---

## Solution: HashMap<val, Set<index>> + List — O(1) average time, O(n) space

**Idea:** Extend the 380 approach. Map each value to a `LinkedHashSet` of indices. On removal, swap with last element (from any of its indices) and update both sets.

**Algorithm:**
1. `insert(val)`: add `list.size()` to `map[val]`, append to list. Return whether it was absent.
2. `remove(val)`: take any index `idx` from `map[val]`. Swap with last element, update that element's index set. Remove old index from sets and trim list.
3. `getRandom()`: return `list[random index]`.

**Complexity:**

| | |
|---|---|
| Time | O(1) average |
| Space | O(n) |
