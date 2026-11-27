# 846. Hand of Straights — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/hand-of-straights/

---

## Solution: Greedy with Sorted Map — O(n log n) time, O(n) space

**Idea:** Sort the unique card values. For each smallest remaining card, try to form a consecutive group of size `groupSize`. Use a frequency map; if any card in the sequence is unavailable, return false.

**Algorithm:**
1. Count frequency of each card value.
2. Use a sorted set of keys.
3. For each smallest key with count > 0, subtract 1 from each of the next `groupSize` values; if any is missing, return false.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting + map operations |
| Space | O(n) — frequency map |
