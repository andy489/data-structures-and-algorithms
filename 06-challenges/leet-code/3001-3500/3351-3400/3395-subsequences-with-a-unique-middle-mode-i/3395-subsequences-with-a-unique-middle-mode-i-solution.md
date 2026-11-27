# 3395. Subsequences With a Unique Middle Mode I — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/subsequences-with-a-unique-middle-mode-i/

---

## Solution: Enumerate Middle Element — O(n^2) time, O(n) space

**Idea:** For each index `mid`, treat `nums[mid]` as the middle of the subsequence. We need to choose 2 elements from indices before `mid` and 2 from indices after `mid`. The middle value must appear strictly more than any other value in the chosen 5-element subsequence.

The total count of valid subsequences = (all ways to pick 2 before and 2 after) − (ways where the middle is NOT the unique mode).

We use inclusion-exclusion. For a fixed middle `m = nums[mid]`:
- Let `leftTotal` = number of elements strictly before `mid`.
- Let `rightTotal` = number of elements strictly after `mid`.
- Let `leftM` = count of `m` before `mid`, `rightM` = count of `m` after `mid`.
- Total ways to pick 2 left and 2 right: `C(leftTotal, 2) * C(rightTotal, 2)`.
- Subtract cases where some other value `v` ties or beats the middle:
  - Case 1: `v` appears ≥ 2 times in left and right combined (ties with middle if middle appears once, beats if middle appears zero times among the picked elements on that side).

For efficiency with n ≤ 1000, we iterate over each pair of indices `(i, mid)` where `i < mid`, building prefix counts as we sweep `mid` from left to right.

**Algorithm:**
1. Coordinate-compress or use a HashMap for counts.
2. For each `mid`, maintain `leftCount` map as we advance.
3. For each `mid`, mirror symmetrically for the right side.
4. Use combinatorial formula with prefix sums.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) — for each mid, O(n) work |
| Space | O(n) — frequency maps |
