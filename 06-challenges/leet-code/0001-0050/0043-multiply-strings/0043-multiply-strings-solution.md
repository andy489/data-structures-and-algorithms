# 43. Multiply Strings — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/multiply-strings/

---

## Solution: Grade-school multiplication — O(m·n) time, O(m+n) space

**Idea:** Simulate digit-by-digit multiplication as on paper. The product of `num1[i]` and `num2[j]` contributes to positions `i+j` and `i+j+1` in the result array (indexed from the left, with the result array of size `m+n`). Accumulate all partial products into this array, then handle carries and strip leading zeros.

**Algorithm:**
1. Allocate `int[] pos` of size `m + n` (max possible product length).
2. Iterate `i` from `m-1` down to 0, `j` from `n-1` down to 0.
3. `mul = (num1[i]-'0') * (num2[j]-'0')`.
4. `p1 = i+j`, `p2 = i+j+1`. `sum = mul + pos[p2]`.
5. `pos[p2] = sum % 10`, `pos[p1] += sum / 10`.
6. Build result string skipping leading zeros; return `"0"` if empty.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — every digit pair multiplied once |
| Space | O(m+n) — result array |
