# 1678. Goal Parser Interpretation — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/goal-parser-interpretation/

---

## Solution: String Replace — O(n) time, O(n) space

**Idea:** Replace `"()"` with `"o"` and `"(al)"` with `"al"`. The order matters: replace `"(al)"` first to avoid partial conflicts, or use a single pass.

**Algorithm:**
1. Replace all occurrences of `"()"` with `"o"`.
2. Replace all occurrences of `"(al)"` with `"al"`.
3. Return the result.

Alternatively, do a single linear scan building the output character by character.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — output string |
