# 981. Time Based Key-Value Store — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/time-based-key-value-store/

---

## Solution: HashMap + Binary Search — O(log n) per get, O(1) per set

**Idea:** Store `(timestamp, value)` pairs per key in sorted order. Use binary search for `get`.

**Complexity:**

| | |
|---|---|
| Time | O(1) set, O(log n) get |
| Space | O(n) — total entries |
