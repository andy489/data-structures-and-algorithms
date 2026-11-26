# 1588. Sum of All Odd Length Subarrays — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/sum-of-all-odd-length-subarrays/

---

## Solution: Math Contribution — O(n) time, O(1) space

**Idea:** For each element `arr[i]`, count how many odd-length subarrays contain it. Element `i` appears in `left * right` total subarrays where `left = i + 1` and `right = n - i`. Of these, `ceil(left * right / 2)` have odd length.

**Algorithm:**
1. For each index `i`, compute `left = i + 1`, `right = n - i`.
2. Total subarrays containing `i` = `left * right`. Odd-length count = `(left * right + 1) / 2`.
3. Add `arr[i] * oddCount` to the sum.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — no extra space |
