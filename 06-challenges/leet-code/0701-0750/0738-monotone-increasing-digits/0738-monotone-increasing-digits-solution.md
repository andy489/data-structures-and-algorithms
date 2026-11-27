# 738. Monotone Increasing Digits — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/monotone-increasing-digits/

---

## Solution: Greedy Right-to-Left Scan — O(d) time, O(d) space

**Idea:** Convert to digit array. Scan right to left: when digits[i-1] > digits[i], decrement digits[i-1] and mark that all digits from i onward should be '9'. This greedily finds the largest monotone number ≤ n.

**Algorithm:**
1. Convert n to char array.
2. Track `mark = len` (index from which to fill 9s).
3. From right to left: if `digits[i-1] > digits[i]`, decrement `digits[i-1]`, set `mark = i`.
4. Fill positions `[mark, len)` with '9'.
5. Parse and return.

**Complexity:**

| | |
|---|---|
| Time | O(d) — d = number of digits |
| Space | O(d) — char array |
