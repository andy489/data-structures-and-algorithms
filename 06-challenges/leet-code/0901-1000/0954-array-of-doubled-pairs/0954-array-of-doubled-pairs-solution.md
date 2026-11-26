# 954. Array of Doubled Pairs — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/array-of-doubled-pairs/

---

## Solution: Sort by Absolute Value + Frequency Map — O(n log n) time, O(n) space

**Idea:** Sort by absolute value. For each element, check if its double exists in the frequency map.

**Algorithm:**
1. Count frequencies.
2. Sort unique keys by absolute value.
3. For each key, pair it with 2*key; if count insufficient, return false.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting |
| Space | O(n) — frequency map |
