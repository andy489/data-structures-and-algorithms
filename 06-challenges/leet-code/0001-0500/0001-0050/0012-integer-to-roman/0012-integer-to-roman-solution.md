# 12. Integer to Roman — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/integer-to-roman/

---

## Solution

### Greedy with Value Table — O(1) time, O(1) space

**Idea:** Pre-build a table of all 13 value-symbol pairs in descending order, including the 6 subtractive forms. Then greedily subtract the largest possible value and append its symbol until `num` reaches 0.

**Value table:**
```
(1000, "M"), (900, "CM"), (500, "D"), (400, "CD"),
(100, "C"),  (90, "XC"),  (50, "L"),  (40, "XL"),
(10, "X"),   (9, "IX"),   (5, "V"),   (4, "IV"), (1, "I")
```

**Algorithm:**
1. For each `(value, symbol)` pair (in descending order):
   - While `num >= value`: append `symbol` to result, subtract `value` from `num`.
2. Return the result string.

**Why O(1)?** `num` is bounded by 3999, and the maximum output length is bounded (e.g., 3888 = "MMMDCCCLXXXVIII" = 15 chars). Both the loop count and output length are constant.

**Complexity:**

| | |
|---|---|
| Time | O(1) — bounded by fixed input range |
| Space | O(1) — fixed output length |
