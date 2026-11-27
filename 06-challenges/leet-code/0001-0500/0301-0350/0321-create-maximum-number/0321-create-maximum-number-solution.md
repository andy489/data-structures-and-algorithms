# 321. Create Maximum Number — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/create-maximum-number/

---

## Solution: Monotonic Stack + Merge — O(k * (m+n)) time, O(m+n) space

**Idea:** For each split `(i, k-i)` where we take `i` digits from `nums1` and `k-i` from `nums2`: extract the max subsequence of length `i` from `nums1` using a monotonic stack, same for `nums2`, then merge the two subsequences by always picking the lexicographically larger remaining sequence.

**Algorithm:**
1. For each split `i` from `max(0, k-n)` to `min(k, m)`:
   a. `sub1 = maxSubsequence(nums1, i)`
   b. `sub2 = maxSubsequence(nums2, k-i)`
   c. `candidate = merge(sub1, sub2)`
   d. Track max candidate.
2. `maxSubsequence(nums, length)`: use a monotonic decreasing stack, dropping elements when we can still afford to.
3. `merge(a, b)`: at each step compare remaining suffixes; pick from whichever is larger.

**Complexity:**

| | |
|---|---|
| Time | O(k * (m+n)) — k splits, each O(m+n) |
| Space | O(m+n) — subsequences |
