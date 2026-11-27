# 1512. Number of Good Pairs — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/number-of-good-pairs/

---

## Solution: Frequency Count — O(n) time, O(n) space

**Idea:** For each number, if it has appeared `c` times before the current occurrence, it forms `c` new good pairs with the current element. Use a frequency map and accumulate.

**Algorithm:**
1. Maintain a `count` map.
2. For each `num` in `nums`: add `count[num]` to result, then increment `count[num]`.
3. Return result.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — frequency map (O(1) since values ≤ 100) |
