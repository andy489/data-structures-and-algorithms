# 238. Product of Array Except Self — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/product-of-array-except-self/

---

## Solution: Prefix + Suffix Products — O(n) time, O(1) extra space

**Idea:** `answer[i]` = product of all elements to the left of `i` × product of all elements to the right of `i`. Compute left products directly into `answer`, then multiply right products on a second pass using a running variable `suffix`.

**Algorithm:**
1. First pass (left to right): `answer[i] = prefix` where `prefix` accumulates `nums[0..i-1]`.
2. Second pass (right to left): `answer[i] *= suffix` where `suffix` accumulates `nums[i+1..n-1]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two passes |
| Space | O(1) extra (output array not counted) |
