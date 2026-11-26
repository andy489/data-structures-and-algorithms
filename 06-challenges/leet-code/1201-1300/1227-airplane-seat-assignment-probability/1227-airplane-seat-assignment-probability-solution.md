# 1227. Airplane Seat Assignment Probability — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/airplane-seat-assignment-probability/

---

## Solution: Mathematical Insight — O(1) time, O(1) space

**Idea:** For n=1, probability is 1.0. For n>1, the probability is always 0.5 due to a symmetry argument: the first passenger either takes their own seat or the last seat, and by induction each step preserves this symmetry.

**Algorithm:**
1. If n==1, return 1.0.
2. Otherwise return 0.5.

**Complexity:**

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |
