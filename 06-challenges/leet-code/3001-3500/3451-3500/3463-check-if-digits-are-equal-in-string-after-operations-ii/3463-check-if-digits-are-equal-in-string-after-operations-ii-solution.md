# 3463. Check If Digits Are Equal in String After Operations II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-ii/

---

## Solution: Pascal's Triangle / Combinatorics — O(n) time, O(n) space

**Idea:** After n-2 rounds of pairwise summation mod 10, the final two digits are weighted sums of the original digits using binomial coefficients C(n-2, k) mod 10. The first final digit = sum(C(n-2,i) * d[i]) mod 10 for i in 0..n-2, the second = sum(C(n-2,i) * d[i+1]) mod 10 for i in 0..n-2.

**Algorithm:**
1. Compute binomial coefficients C(n-2, 0), C(n-2, 1), ..., C(n-2, n-2) mod 10 using Lucas' theorem.
2. Compute the weighted sum for position 0 (using digits 0..n-2) and position 1 (using digits 1..n-1).
3. Return whether these two values are equal mod 10.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
