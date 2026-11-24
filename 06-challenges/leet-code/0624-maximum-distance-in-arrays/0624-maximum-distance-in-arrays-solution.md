# 624. Maximum Distance in Arrays — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-distance-in-arrays/

---

## Solution: Running Min/Max — O(m) time, O(1) space

**Idea:** Track global min and max seen so far from previous arrays. For each new array, the max distance is max(last[i] - globalMin, globalMax - first[i]). Update global min/max after computing.

**Algorithm:**
1. Initialize globalMin = arrays[0][0], globalMax = arrays[0][last].
2. For each subsequent array: compute candidate distances using its first/last vs running min/max.
3. Update running min and max.

**Complexity:**

| | |
|---|---|
| Time | O(m) — one pass |
| Space | O(1) — just two variables |
