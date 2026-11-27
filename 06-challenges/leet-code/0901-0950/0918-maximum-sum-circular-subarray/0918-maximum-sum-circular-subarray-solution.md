# 918. Maximum Sum Circular Subarray — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-sum-circular-subarray/

---

## Solution: Kadane's + Total Sum Trick — O(n) time, O(1) space

**Idea:** Max circular subarray is either (1) a normal max subarray (Kadane's), or (2) total - min subarray (the "gap" on both ends forms the circular part). Answer is max of these two, unless all elements are negative.

**Algorithm:**
1. Compute maxSum (Kadane's), minSum (Kadane's on negated), and total.
2. If all negative (maxSum < 0), return maxSum.
3. Else return max(maxSum, total - minSum).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
