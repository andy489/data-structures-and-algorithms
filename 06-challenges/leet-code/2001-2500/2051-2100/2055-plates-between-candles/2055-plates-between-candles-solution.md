# 2055. Plates Between Candles — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/plates-between-candles/

---

## Solution: Prefix Sums + Binary Search — O((n + q) log n) time, O(n) space

**Idea:** Precompute prefix counts of plates, and sorted list of candle positions. For each query, find nearest candles and count plates between.

**Algorithm:**
1. Precompute prefix sum of '*' plates.
2. Store sorted list of candle indices.
3. For each query, binary search for leftmost candle >= left and rightmost candle <= right.
4. If both found, answer = plates[rightCandle] - plates[leftCandle].

**Complexity:**

| | |
|---|---|
| Time | O((n + q) log n) |
| Space | O(n) |
