# 969. Pancake Sorting — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/pancake-sorting/

---

## Solution: Selection Sort with Flips — O(n²) time, O(n) space

**Idea:** To place element of value `i` at position `i-1`: flip it to front, then flip it to its target position.

**Algorithm:**
1. For size from n down to 2: find position of max element.
2. If not at front, flip to front.
3. Flip to position `size`.

**Complexity:**

| | |
|---|---|
| Time | O(n²) |
| Space | O(n) — result list |
