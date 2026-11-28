# 3471. Find the Largest Almost Missing Integer — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-the-largest-almost-missing-integer/

---

## Solution: Count Subarray Appearances — O(n * k) time, O(n) space

**Idea:** Count how many subarrays of size k contain each element. An element is "almost missing" if this count is exactly 1. Return the largest such element.

**Algorithm:**
1. For each index i, iterate over all subarrays of size k that include position i (window starts from max(0, i-k+1) to min(n-k, i)).
2. Use a map to count how many subarrays of size k contain each value.
3. Find the maximum value among those with count exactly 1.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
