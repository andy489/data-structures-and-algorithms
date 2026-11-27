# 300. Longest Increasing Subsequence — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-increasing-subsequence/

---

## Solution 1: Dynamic Programming — O(n²) time, O(n) space

**Idea:** `dp[i]` = length of LIS ending at index `i`. For each `i`, scan all `j < i` and if `nums[j] < nums[i]`, update `dp[i] = max(dp[i], dp[j] + 1)`.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — nested loops |
| Space | O(n) — dp array |

---

## Solution 2: Binary Search (Patience Sorting) — O(n log n) time, O(n) space

**Idea:** Maintain a `tails` array where `tails[i]` is the smallest tail element of all increasing subsequences of length `i+1`. For each `num`, binary search for the leftmost position in `tails` where `tails[pos] >= num` and replace `tails[pos] = num`. If `num` is larger than all, extend. The length of `tails` is the answer.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — binary search per element |
| Space | O(n) — tails array |
