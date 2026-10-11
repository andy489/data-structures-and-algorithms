# 9. Palindrome Number — Solution

**Difficulty:** Easy  
**Link:** https://leetcode.com/problems/palindrome-number/

---

## Solution

### Reverse Half the Number — O(log x) time, O(1) space

**Key observations:**
- Negative numbers are never palindromes.
- Numbers ending in 0 (except 0 itself) are not palindromes, since the reversed number would have a leading zero.

**Idea:** Instead of reversing the full number (which risks overflow), reverse only the second half and compare with the first half.

**Algorithm:**
1. Return `false` for `x < 0` or (`x % 10 == 0` and `x != 0`).
2. Build `reversedHalf` by repeatedly taking `x % 10` and appending: `reversedHalf = reversedHalf * 10 + x % 10`, then `x /= 10`.
3. Stop when `reversedHalf >= x` (we've processed the second half).
4. Palindrome if:
   - `x == reversedHalf` (even number of digits), or
   - `x == reversedHalf / 10` (odd number of digits — discard the middle digit).

**Why only half?** Comparing the full reversal risks 32-bit overflow; comparing half is safe since the reversed half is at most as large as the original.

**Complexity:**

| | |
|---|---|
| Time | O(log₁₀ x) — number of digits / 2 iterations |
| Space | O(1) |
