# 1432. Max Difference You Can Get From Changing An Integer — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/

---

## Solution: Greedy Digit Replacement — O(d) time, O(d) space

**Idea:** To maximize: replace first non-9 digit with 9. To minimize: replace first digit ≠ 1 with 1; if it's the leading digit, else replace first non-0,non-first with 0.

**Algorithm:**
1. Convert to string. Max: find first char != '9', replace all with '9'.
2. Min: if first char != '1', replace all first char with '1'; else find first non-leading char not '0' or '1', replace with '0'.
3. Return max - min.

**Complexity:**

| | |
|---|---|
| Time | O(d) |
| Space | O(d) |
