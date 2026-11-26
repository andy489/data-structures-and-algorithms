# 3069. Distribute Elements Into Two Arrays I — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/distribute-elements-into-two-arrays-i/

---

## Solution: Simulation — O(n) time, O(n) space

**Idea:** Simulate directly per the problem description.

**Algorithm:**
1. arr1=[nums[0]], arr2=[nums[1]].
2. For i>=2: if arr1.last > arr2.last, append to arr1 else arr2.
3. Return arr1 + arr2.

**Complexity:**

| | |
|---|---|
| Time | O(n) — O(n) |
| Space | O(n) — O(n) |
