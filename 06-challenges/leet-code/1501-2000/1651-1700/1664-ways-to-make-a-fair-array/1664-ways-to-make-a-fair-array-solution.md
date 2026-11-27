# 1664. Ways to Make a Fair Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/ways-to-make-a-fair-array/

---

## Solution: Prefix Sums — O(n) time, O(1) space

**Idea:** Precompute total even-indexed and odd-indexed sums. Then iterate through each removal index `i`. When we remove index `i`, all elements after `i` swap their parity (even becomes odd and vice versa). Track prefix sums and check fairness in O(1) per index.

**Algorithm:**
1. Compute `totalEven` and `totalOdd` (sums at even/odd positions).
2. Iterate with `prefixEven` and `prefixOdd` maintained.
3. At index `i`: after removal, the even sum = `prefixEven` + (what was odd after `i`) and similarly for odd sum.
4. Check if they are equal; increment count.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
