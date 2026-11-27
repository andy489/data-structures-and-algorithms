# 1722. Minimize Hamming Distance After Swap Operations — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/

---

## Solution: Union-Find (Group Matching) — O(n · α(n)) time, O(n) space

**Idea:** Indices connected by allowed swaps form groups where elements can be freely rearranged. For each group, greedily match source elements to target elements using a frequency map — unmatched target positions contribute to Hamming distance.

**Algorithm:**
1. Build a Union-Find over indices using `allowedSwaps`.
2. Group all indices by their root using a map `root -> list of indices`.
3. For each group: build a frequency map of source values in the group. For each target value in the group, if it exists in the map, decrement count (match found, Hamming distance not incremented); otherwise increment distance.
4. Return total Hamming distance.

**Complexity:**

| | |
|---|---|
| Time | O(n · α(n)) — union-find operations |
| Space | O(n) — parent array and frequency maps |
