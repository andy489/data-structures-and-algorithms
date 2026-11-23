# 303. Range Sum Query - Immutable — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/range-sum-query-immutable/

---

## Solution: Prefix Sum — O(n) build, O(1) query, O(n) space

**Idea:** Precompute a prefix sum array where `prefix[i]` is the sum of `nums[0..i-1]`. Then `sumRange(left, right) = prefix[right+1] - prefix[left]`.

**Algorithm:**
1. Build `prefix[0..n]` where `prefix[0] = 0` and `prefix[i] = prefix[i-1] + nums[i-1]`.
2. For `sumRange(left, right)`, return `prefix[right+1] - prefix[left]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) build, O(1) per query |
| Space | O(n) — prefix array |
