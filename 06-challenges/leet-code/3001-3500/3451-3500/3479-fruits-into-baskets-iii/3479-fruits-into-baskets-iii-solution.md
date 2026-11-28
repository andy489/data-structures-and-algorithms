# 3479. Fruits Into Baskets III — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/fruits-into-baskets-iii/

---

## Solution: Segment Tree — O(n log n) time, O(n) space

**Idea:** Use a segment tree on the basket array to efficiently find the leftmost basket with capacity >= fruits[i]. Query `max` in a range, and when found, narrow by binary search within the segment tree to identify the leftmost valid index.

**Algorithm:**
1. Build a segment tree storing max basket capacity for each range.
2. For each fruit, query segment tree from index 0: find leftmost index where basket >= fruit.
3. Mark that basket as used (set capacity to 0 in tree).
4. Count unplaced fruits.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
