# 66. Plus One — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/plus-one/

---

## Solution: Right-to-Left Carry Propagation — O(n) time, O(1) space

**Idea:** Adding one to a number only causes a carry when the current digit is 9 (9 + 1 = 10, write 0, carry 1). Walk from the last digit leftward: set each 9 to 0 and continue; for any digit less than 9, increment it and return immediately. If every digit was 9, they all become 0 and we prepend a 1.

**Algorithm:**
1. Traverse `digits` from right to left.
2. If `digits[i] < 9`: increment it and return — no carry propagates further.
3. If `digits[i] == 9`: set it to 0 and continue to the next digit.
4. If the loop completes (all digits were 9), prepend `1` to the array and return.

**Why this covers all cases:**
- `[1,2,3]` → last digit 3 < 9 → increment to 4 → `[1,2,4]` ✓
- `[1,9,9]` → 9→0, 9→0, 1<9 → increment → `[2,0,0]` ✓
- `[9,9,9]` → all 9s become 0 → prepend 1 → `[1,0,0,0]` ✓

**Complexity:**

| | |
|---|---|
| Time  | O(n) — visit each digit at most once |
| Space | O(1) — in-place except the rare all-9s case which allocates a new array of size n+1 |

---

## Worked Example — `digits = [9, 9, 9]`

| i | digits[i] | action | array |
|---|-----------|--------|-------|
| 2 | 9 | set to 0 | [9,9,0] |
| 1 | 9 | set to 0 | [9,0,0] |
| 0 | 9 | set to 0 | [0,0,0] |
| — | — | loop ends → prepend 1 | [1,0,0,0] |

**Answer: `[1,0,0,0]`** ✓
