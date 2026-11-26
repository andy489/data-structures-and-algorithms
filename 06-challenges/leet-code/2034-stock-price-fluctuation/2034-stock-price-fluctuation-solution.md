# 2034. Stock Price Fluctuation — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/stock-price-fluctuation/

---

## Solution: TreeMap — O(log n) per op time, O(n) space

**Idea:** Store prices by timestamp in a map. Use a sorted map (TreeMap) to track price frequencies.

**Algorithm:**
1. HashMap: timestamp → price.
2. TreeMap: price → count.
3. On update: decrement old price count, increment new.
4. max/min from TreeMap ends.

**Complexity:**

| | |
|---|---|
| Time | O(log n) per op |
| Space | O(n) |
