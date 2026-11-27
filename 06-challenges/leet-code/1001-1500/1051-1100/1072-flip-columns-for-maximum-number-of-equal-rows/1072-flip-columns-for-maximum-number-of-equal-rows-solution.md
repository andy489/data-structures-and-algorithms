# 1072. Flip Columns For Maximum Number of Equal Rows — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/

---

## Solution: HashMap of Row Patterns — O(m*n) time, O(m*n) space

**Idea:** Two rows can become all-equal simultaneously iff one is the complement of the other (or they're identical). Normalize each row to start with 0 and count frequencies.

**Algorithm:**
1. For each row, if it starts with 1, flip it to get the canonical pattern.
2. Count frequencies of each canonical pattern.
3. Return max frequency.

**Complexity:**

| | |
|---|---|
| Time | O(m*n) |
| Space | O(m*n) |
