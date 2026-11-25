# 306. Additive Number — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/additive-number/

---

## Solution: Enumerate First Two + BigInteger Addition — O(n³) time, O(n) space

**Idea:** Try all pairs (a, b) as the first two numbers, verify the rest of the string matches the additive sequence using string-based big integer addition.

**Algorithm:**
1. Enumerate all splits i (end of first number) and j (end of second number).
2. Skip leading zeros.
3. Repeatedly compute c = a + b as a string, check if `num` has `c` as prefix at current position.
4. Return true if entire string consumed.

**Complexity:**

| | |
|---|---|
| Time | O(n³) |
| Space | O(n) |
