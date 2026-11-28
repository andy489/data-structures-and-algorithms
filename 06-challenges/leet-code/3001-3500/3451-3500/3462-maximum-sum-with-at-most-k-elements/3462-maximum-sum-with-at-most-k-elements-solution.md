# 3462. Maximum Sum With at Most K Elements — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-sum-with-at-most-k-elements/

---

## Solution: Greedy with Global Max Heap — O(n * m * log(n * m)) time, O(n * m) space

**Idea:** From each row, take the top limits[i] elements. Then collect all candidate elements from all rows into a max heap and greedily take the top k elements.

**Algorithm:**
1. For each row i, sort the row in descending order and pick the top limits[i] elements as candidates.
2. Add all candidates to a global max heap (priority queue).
3. Pop at most k elements from the heap and sum them.
4. Return the sum.

**Complexity:**

| | |
|---|---|
| Time | O(n * m * log(n * m)) |
| Space | O(n * m) |
