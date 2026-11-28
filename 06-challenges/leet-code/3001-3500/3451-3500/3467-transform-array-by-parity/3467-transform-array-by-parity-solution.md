# 3467. Transform Array by Parity — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/transform-array-by-parity/

---

## Solution: Count Odds — O(n) time, O(1) space

**Idea:** After replacing evens with 0 and odds with 1, sorting produces an array of all 0s followed by all 1s. So simply count the number of odd elements; the first (n - oddCount) elements are 0 and the remaining oddCount are 1.

**Algorithm:**
1. Count the number of odd elements in nums.
2. Build the result: fill positions 0..n-oddCount-1 with 0, positions n-oddCount..n-1 with 1.
3. Return the result.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
