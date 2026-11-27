# 1402. Reducing Dishes — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/reducing-dishes/

---

## Solution: Sort + Suffix Sum Greedy — O(n log n) time, O(1) space

**Idea:** Sort descending. Including a dish adds its value to every future position, so greedily add while the cumulative suffix is positive.

**Algorithm:**
1. Sort descending.
2. Track `suffixSum` and `total`.
3. For each dish: if `suffixSum + dish <= 0`, stop. Else `suffixSum += dish`, `total += suffixSum`.
4. Return `total`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(1) |
