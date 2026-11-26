# 415. Add Strings — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/add-strings/

---

## Solution: Two-Pointer Simulation — O(max(m,n)) time, O(max(m,n)) space

**Idea:** Simulate grade-school addition from the least significant digit (right to left). Maintain a carry. Build the result in a `StringBuilder` and reverse at the end.

**Algorithm:**
1. Initialize pointers `i = num1.length()-1`, `j = num2.length()-1`, `carry = 0`.
2. While either pointer is valid or carry != 0: sum current digits + carry; append `sum % 10`; `carry = sum / 10`.
3. Reverse the `StringBuilder` and return.

**Complexity:**

| | |
|---|---|
| Time | O(max(m,n)) — iterate over both strings |
| Space | O(max(m,n)) — output string |
