# 881. Boats to Save People — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/boats-to-save-people/

---

## Solution: Two Pointers (Sort + Greedy) — O(n log n) time, O(1) space

**Idea:** Sort people. Use two pointers: try to pair lightest with heaviest. If they fit, both board; otherwise heaviest boards alone.

**Algorithm:**
1. Sort people.
2. lo = 0, hi = n - 1, boats = 0.
3. While lo <= hi: if people[lo] + people[hi] <= limit, lo++; hi--; boats++.
4. Return boats.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(1) |
