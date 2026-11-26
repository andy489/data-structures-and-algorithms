# 904. Fruit Into Baskets — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/fruit-into-baskets/

---

## Solution: Sliding Window — O(n) time, O(1) space

**Idea:** Longest subarray with at most 2 distinct values. Use a sliding window with a frequency map; shrink left when more than 2 distinct types.

**Algorithm:**
1. Maintain `left` pointer and count map.
2. For each `right`: add `fruits[right]` to map.
3. While map size > 2: decrement `fruits[left]`, remove if 0, increment `left`.
4. Track max window size.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) — at most 3 entries in map |
