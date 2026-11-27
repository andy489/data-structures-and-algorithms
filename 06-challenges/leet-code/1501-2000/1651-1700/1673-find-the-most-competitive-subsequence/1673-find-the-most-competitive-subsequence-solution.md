# 1673. Find the Most Competitive Subsequence — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-the-most-competitive-subsequence/

---

## Solution: Monotonic Stack — O(n) time, O(k) space

**Idea:** Use a monotonic stack to greedily build the lexicographically smallest subsequence of length `k`. At each element, pop larger elements from the stack as long as we have enough remaining elements to still fill `k` spots.

**Algorithm:**
1. Iterate through `nums` with index `i`.
2. While stack is not empty, top > `nums[i]`, and `stack.size() + (n - i) > k`: pop top.
3. If `stack.size() < k`: push `nums[i]`.
4. Return the stack as array.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each element pushed/popped at most once |
| Space | O(k) — the stack |
