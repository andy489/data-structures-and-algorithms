# 1046. Last Stone Weight — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/last-stone-weight/

---

## Solution: Max Heap — O(n log n) time, O(n) space

**Idea:** Use a max heap to always get the two heaviest stones.

**Algorithm:**
1. Add all stones to a max heap.
2. While heap has more than 1 stone: extract two max, if different push difference.
3. Return remaining stone or 0.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
