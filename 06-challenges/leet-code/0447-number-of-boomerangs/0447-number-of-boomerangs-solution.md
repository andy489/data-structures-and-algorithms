# 447. Number of Boomerangs — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-boomerangs/

---

## Solution: HashMap of Squared Distances — O(n²) time, O(n) space

**Idea:** For each point `i`, build a frequency map of squared distances to all other points. For each distance with `k` equidistant points, there are `k*(k-1)` ordered pairs `(j, k)`.

**Algorithm:**
1. For each point `i`, create empty `distanceCounts` map.
2. For each other point `j`, compute squared distance (avoid sqrt), increment count.
3. For each count `k` in map: add `k * (k - 1)` to result.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — n points × n distances |
| Space | O(n) — distance map per point |
