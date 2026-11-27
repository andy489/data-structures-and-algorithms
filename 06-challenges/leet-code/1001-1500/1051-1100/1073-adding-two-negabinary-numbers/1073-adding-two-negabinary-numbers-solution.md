# 1073. Adding Two Negabinary Numbers — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/adding-two-negabinary-numbers/

---

## Solution: Bit-by-Bit Addition with Carry — O(max(m,n)) time, O(max(m,n)) space

**Idea:** Add from LSB. At each bit position sum = a + b + carry. The negabinary carry propagates differently: if sum == 2, bit=0, carry=-1; if sum == 3, bit=1, carry=-1; if sum == -1, bit=1, carry=1.

**Algorithm:**
1. Reverse both arrays. Add bit by bit with carry.
2. Carry rules: sum & 1 = current bit; carry = -(sum >> 1).
3. Remove leading zeros.

**Complexity:**

| | |
|---|---|
| Time | O(max(m,n)) |
| Space | O(max(m,n)) |
