# 1206. Design Skiplist — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/design-skiplist/

---

## Solution: Skiplist with Random Levels — O(log n) expected time, O(n log n) space

**Idea:** Implement a standard skiplist with MAX_LEVEL levels. Each node has random height. Use dummy head node.

**Algorithm:**
1. Use MAX_LEVEL=16, probability=0.5.
2. Each node stores value and array of forward pointers.
3. search/add/erase traverse from top level down.

**Complexity:**

| | |
|---|---|
| Time | O(log n) expected |
| Space | O(n log n) |
