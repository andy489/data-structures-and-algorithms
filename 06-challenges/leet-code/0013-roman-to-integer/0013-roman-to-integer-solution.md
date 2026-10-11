# 13. Roman to Integer — Solution

**Difficulty:** Easy  
**Link:** https://leetcode.com/problems/roman-to-integer/

---

## Solution

### Single Pass with Lookahead — O(n) time, O(1) space

**Key observation:** In a valid Roman numeral, a symbol is subtracted only when it is immediately followed by a larger symbol. Otherwise it is added.

**Algorithm:**
1. Build a map of symbol → value.
2. Traverse the string left to right:
   - If the current symbol's value is **less than** the next symbol's value: **subtract** the current value.
   - Otherwise: **add** the current value.
3. Always add the last symbol (no next character to compare against).

**Why this works:** The six subtractive cases are exactly the situations where a smaller value precedes a larger one. This single rule handles all of them uniformly.

**Complexity:**

| | |
|---|---|
| Time | O(n) — one pass through the string |
| Space | O(1) — fixed-size symbol map |
