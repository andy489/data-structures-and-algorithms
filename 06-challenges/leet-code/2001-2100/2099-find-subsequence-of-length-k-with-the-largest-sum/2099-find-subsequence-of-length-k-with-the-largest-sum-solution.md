# 2099. Find Subsequence of Length K With the Largest Sum — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/

---

## Solution: Sort by Value, Keep Original Order — O(n log n) time, O(n) space

**Idea:** Find indices of the k largest elements, sort those indices, return elements at those indices.

**Algorithm:**
1. Create index array sorted by `nums[i]` descending.
2. Take first `k` indices.
3. Sort those indices ascending.
4. Return `nums[i]` for each selected index.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
