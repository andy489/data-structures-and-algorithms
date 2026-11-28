# 3461. Check If Digits Are Equal in String After Operations I — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/

---

## Solution: Simulation — O(n^2) time, O(n) space

**Idea:** Directly simulate the operations. At each step reduce the string by one character by computing adjacent sums mod 10. When length is 2, check equality.

**Algorithm:**
1. Convert string to digit array.
2. Repeatedly apply the operation: for each pair of consecutive digits, compute (a + b) % 10 and form a new array.
3. Stop when length is 2.
4. Return whether the two digits are equal.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) |
| Space | O(n) |
