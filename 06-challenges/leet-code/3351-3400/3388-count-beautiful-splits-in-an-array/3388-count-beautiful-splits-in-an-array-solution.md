# 3388. Count Beautiful Splits in an Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-beautiful-splits-in-an-array/

---

## Solution: Z-Function (LCP Arrays) — O(n^2) time, O(n^2) space

**Idea:** A split at positions `(i, j)` (1-indexed split points, 0 < i < j < n) is beautiful when:
- **Condition A**: `nums1 = nums[0..i-1]` is a prefix of `nums2 = nums[i..j-1]`, which requires `i <= j-i` and `lcp(0, i) >= i`.
- **Condition B**: `nums2 = nums[i..j-1]` is a prefix of `nums3 = nums[j..n-1]`, which requires `j-i <= n-j` and `lcp(i, j) >= j-i`.

Where `lcp(a, b)` is the length of the longest common prefix of `nums[a..]` and `nums[b..]`.

Precompute a 2D LCP table: `lcp[i][j]` = length of longest common prefix of `nums[i..]` and `nums[j..]`, computed bottom-up in O(n²). Then iterate over all split pairs `(i, j)`.

**Algorithm:**
1. Build `lcp[i][j]` bottom-up: if `nums[i] == nums[j]`, then `lcp[i][j] = lcp[i+1][j+1] + 1`; else 0.
2. For each split point pair `0 < i < j < n`:
   - Check A: `i <= j-i` and `lcp[0][i] >= i`.
   - Check B: `j-i <= n-j` and `lcp[i][j] >= j-i`.
   - Count if A or B holds.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) — LCP table build and double loop |
| Space | O(n^2) — LCP table |
