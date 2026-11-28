# 2913. Subarrays Distinct Element Sum of Squares I — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/

---

## Solution: Brute Force with HashSet — O(n^3) time, O(n) space

**Idea:** Given the small constraints (n <= 100), enumerate all subarrays, count distinct elements using a set, and add the square of the count to the answer.

**Algorithm:**
1. For each start index `i`, initialize an empty set.
2. Extend the subarray to index `j`, adding `nums[j]` to the set each time.
3. Add `set.size()^2` to the answer.

**Complexity:**

| | |
|---|---|
| Time | O(n^3) |
| Space | O(n) |
