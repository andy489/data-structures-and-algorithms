# 641. Design Circular Deque — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/design-circular-deque/

---

## Solution: Array with Front/Rear Pointers — O(1) operations, O(k) space

**Idea:** Use fixed array with `front` and `rear` indices. `front` points to the front element; `rear` points to the rear element. Use size to track count.

**Complexity:**

| | |
|---|---|
| Time | O(1) — all operations |
| Space | O(k) — fixed array |
