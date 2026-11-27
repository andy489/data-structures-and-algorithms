# 1146. Snapshot Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/snapshot-array/

---

## Solution: Per-Index History with Binary Search — O(log S) get, O(1) amortized set/snap

**Idea:** Instead of copying the full array on each snap (which would be too slow), store for each index a list of `(snap_id, value)` pairs recording only the changes. On `get(index, snap_id)`, binary search the history of that index for the largest snap_id that is `<= snap_id`.

**Algorithm:**
1. Initialize `history[i] = [(0, 0)]` — each index starts with value `0` at snap 0.
2. `set(index, val)`: append `(currentSnapId, val)` to `history[index]`. If the last entry already has `currentSnapId`, replace it instead (optional optimization).
3. `snap()`: increment and return `snapId++`.
4. `get(index, snap_id)`: binary search `history[index]` for the rightmost entry with `entry.snapId <= snap_id`. Return its value.

**Complexity:**

| | |
|---|---|
| Time | O(log S) per `get`, O(1) per `set`/`snap` amortized |
| Space | O(length + total sets) |
