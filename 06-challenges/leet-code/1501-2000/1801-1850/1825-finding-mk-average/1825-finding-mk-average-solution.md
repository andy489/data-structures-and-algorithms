# 1825. Finding MK Average — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/finding-mk-average/

---

## Solution: Three SortedMaps + Deque — O(log n) per add, O(1) per query

**Idea:** Maintain a sliding window of the last `m` elements using a deque. Partition those elements into three sorted multisets: `lower` (smallest `k`), `middle` (middle `m - 2k`), and `upper` (largest `k`). Track the sum of the `middle` partition. When adding or removing elements, rebalance the partitions to maintain their target sizes. The MK average is `middleSum / middleSize`.

**Algorithm:**
1. On `addElement(num)`:
   - Add `num` to the deque and the appropriate partition (fill `lower` first, then `upper`, then `middle`).
   - Rebalance: swap elements between `lower`/`middle` and `upper`/`middle` if boundaries are violated.
   - If the window exceeds `m`, remove the oldest element from its partition and rebalance.
2. On `calculateMKAverage()`:
   - Return `-1` if fewer than `m` elements; else return `middleSum / middleSize`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) per `addElement` — TreeMap operations; O(1) per `calculateMKAverage` |
| Space | O(m) — window deque and three partitions each holding up to m elements total |
