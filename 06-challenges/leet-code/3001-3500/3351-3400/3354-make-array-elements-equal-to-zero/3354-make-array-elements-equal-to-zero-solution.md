# 3354. Make Array Elements Equal to Zero — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/make-array-elements-equal-to-zero/

---

## Solution: Prefix Sum Balance Check — O(n) time, O(n) space

**Idea:** For a starting zero at index `i`, moving left means we'll handle everything to the left; moving right means we'll handle everything to the right. The simulation always alternates direction at each non-zero element. The key observation: for a valid selection starting at a zero index `i`:
- Moving **left**: the sum of elements to the left must equal the sum to the right (the pointer bounces, consuming equal amounts on both sides relative to the starting zero).
- Moving **right**: symmetric condition.

More precisely: starting at zero index `i`, moving left is valid if and only if `sum(nums[0..i-1]) == sum(nums[i+1..n-1])`. Moving right has the same condition. So each zero contributes 2 to the answer if prefix sum equals suffix sum, 1 if either prefix or suffix is 0 (the trivial side), or 0 otherwise.

Actually the key insight: for starting at zero `i`:
- Left direction is valid iff `prefix[i] == suffix[i]`
- Right direction is valid iff `prefix[i] == suffix[i]`

Both conditions are identical, so each zero at index `i` adds 2 if prefix == suffix, 1 if prefix == 0 or suffix == 0 (single-sided), else 0.

**Algorithm:**
1. Compute total sum.
2. Iterate over zeros. At each zero index `i`, track `leftSum = prefix sum up to i-1`.
3. `rightSum = total - leftSum`.
4. If `leftSum == rightSum`: add 2. Else if `leftSum == 0` or `rightSum == 0`: add 1.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — only running prefix sum |
