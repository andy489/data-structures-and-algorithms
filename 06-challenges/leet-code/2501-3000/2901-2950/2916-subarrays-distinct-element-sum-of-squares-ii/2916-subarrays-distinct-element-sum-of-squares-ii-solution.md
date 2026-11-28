# 2916. Subarrays Distinct Element Sum of Squares II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-ii/

---

## Solution: Segment Tree with Lazy Propagation — O(n log n) time, O(n) space

**Idea:** Use the identity `sum(d[i]^2) = sum((d[i-1]+delta[i])^2)` where `d[i]` is the distinct count of subarray ending at `i` with start index fixed. When we move right from `i-1` to `i`, some subarrays gain a new distinct element. Using a segment tree that tracks the sum of `d^2` and sum of `d` with lazy increment, we can process each new element by updating ranges corresponding to subarrays where `nums[i]` is new (from `prev[nums[i]]+1` to `i`).

**Algorithm:**
1. For each index `i`, let `p = last occurrence of nums[i]` (or -1 if not seen before).
2. Increment all `d[j]` for `j` in `[p+1, i]` by 1 (these subarrays gain a new distinct element).
3. Sum over `d[j]^2` for `j = 0..i` gives the contribution of all subarrays ending at `i`.
4. Use a segment tree supporting: range add +1 to `d[j]`, query sum of `d[j]^2`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
