# 1656. Design an Ordered Stream — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/design-an-ordered-stream/

---

## Solution: Array with Pointer — O(1) amortized per insert, O(n) space

**Idea:** Store values in a 1-indexed array. Keep a pointer `ptr` at the current expected ID. On each insert, store the value, then advance `ptr` as far as possible collecting consecutive stored values.

**Algorithm:**
1. Initialize `data[n+1]` and `ptr = 1`.
2. On `insert(idKey, value)`: store `data[idKey] = value`.
3. Collect from `ptr` while `data[ptr] != null`, incrementing `ptr`.
4. Return the collected chunk (may be empty).

**Complexity:**

| | |
|---|---|
| Time | O(n) total — each slot is visited at most once |
| Space | O(n) — the data array |
