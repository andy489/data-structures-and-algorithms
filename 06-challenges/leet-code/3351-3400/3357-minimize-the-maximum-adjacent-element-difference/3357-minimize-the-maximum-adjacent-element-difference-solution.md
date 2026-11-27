# 3357. Minimize the Maximum Adjacent Element Difference — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimize-the-maximum-adjacent-element-difference/

---

## Solution: Binary Search on Answer — O(n log(max)) time, O(1) space

**Idea:** Binary search on the answer `d`. For a given `d`, check whether we can assign `x` and `y` to all -1s such that every adjacent pair differs by at most `d`.

Key observations:
1. Adjacent pairs with no -1 have a fixed difference — the answer must be at least `max(|nums[i]-nums[i+1]|)` over all non-(-1) adjacent pairs.
2. For a gap of one or more consecutive -1s between non-(-1) values `a` and `b`: the -1s must be filled with `x` or `y`. The minimum achievable maximum difference across this gap, given the two available values, is `ceil((|a-b|)/2)` if we can place values optimally with one value pair. With binary search on `d`, check: can we fill the gap using only `x` and `y` such that all differences ≤ d?
3. For a valid `d`, we need `x` and `y` such that:
   - `|x - y| <= d` (they must be within d of each other)
   - For each boundary pair `(a, gap_length, b)`: at least one of `x, y` is within d of both endpoints of the gap boundaries.

The feasibility check: for each maximal run of -1s flanked by real values `a` on the left and `b` on the right, we need `x` or `y` to be in `[a-d, a+d]` AND `x` or `y` to be in `[b-d, b+d]`. Specifically, the values placed at the boundary must be within `d` of their neighbors. Each -1 adjacent to a real number must be filled with something within `d` of that number, so the value at that slot must be in an interval. With only two choices `x, y`, each constrains an interval.

Simplified feasibility: for each boundary condition `(a, b)` from a gap (the first and last -1 in the gap get constraints from `a` and `b`):
- The first -1 must have a value in `[a-d, a+d]`
- The last -1 must have a value in `[b-d, b+d]`
- Internal -1s between first and last must transition using `x, y` with `|x-y| ≤ d`

This reduces to: either `x ∈ [a-d,a+d] ∩ [b-d,b+d]` (single value covers both ends), or one of `{x,y}` covers `a` and the other covers `b`, with `|x-y| ≤ d`.

**Algorithm:**
1. Binary search on `d` from 0 to `max(nums)`.
2. For feasibility with given `d`:
   - Compute base `d` from fixed adjacent non-(-1) pairs.
   - For each gap of -1s between real values `a` and `b`: the constraint on `x,y` is that intervals `Ia = [a-d, a+d]` and `Ib = [b-d, b+d]` must together be coverable: either `Ia ∩ Ib != empty` (one value covers both), or we use two values, one from each interval, with difference ≤ d. The latter always holds if `Ia` and `Ib` overlap or if `|a-b| ≤ 2d`.
   - For leading/trailing -1 runs (only one real neighbor), the constraint from one side only: any value within d of the real neighbor works.
3. Collect intervals `Ia` for all left-boundary conditions and `Ib` for all right-boundary conditions. Find if a pair `(x, y)` with `|x-y| ≤ d` can simultaneously cover all constraints.

**Complexity:**

| | |
|---|---|
| Time | O(n log(max)) — binary search over values up to 10^9, O(n) feasibility check |
| Space | O(1) — only tracking intervals |
