# 3487. Maximum Unique Subarray Sum After Deletion — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/

---

## Solution: Greedy — O(n) time, O(n) space

**Idea:** Since we can delete any elements, we can essentially pick any subset of the array's distinct positive values. The optimal strategy is to include each distinct positive value exactly once (via deletions). If all values are negative or zero, return the maximum element.

**Algorithm:**
1. Collect all positive values into a set.
2. If the set is non-empty, return the sum of all distinct positive values.
3. Otherwise, return the maximum element in the array.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
