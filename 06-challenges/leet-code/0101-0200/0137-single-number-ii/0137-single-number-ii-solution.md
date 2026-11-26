# 137. Single Number II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/single-number-ii/

---

## Solution 1: Bit Count per Position — O(n) time, O(1) space

**Idea:** For each of the 32 bit positions, count how many numbers have that bit set. If the count is not divisible by 3, the single number contributes that bit. Reconstruct the answer bit by bit.

**Algorithm:**
1. For each bit position `b` from 0 to 31: count how many elements have bit `b` set.
2. If `count % 3 != 0`, set bit `b` in the answer.
3. Return the answer (cast appropriately for signed 32-bit integers).

**Complexity:**

| | |
|---|---|
| Time  | O(32n) = O(n) — 32 passes of the array |
| Space | O(1) — only integer variables |

---

## Solution 2: Two-Variable Bit Trick (`ones` / `twos`) — O(n) time, O(1) space

**Idea:** Maintain two bitmasks `ones` and `twos` tracking bits that have been seen once and twice respectively. When a bit reaches three occurrences it is cleared from both. After processing all numbers, `ones` holds the bits of the single element.

**Algorithm:**
1. For each number `x`:
   - `ones = (ones ^ x) & ~twos` — add `x` to `ones`, but cancel any bit already in `twos`
   - `twos = (twos ^ x) & ~ones` — add `x` to `twos`, but cancel any bit now in `ones`
2. Return `ones`.

**Complexity:**

| | |
|---|---|
| Time  | O(n) — single pass |
| Space | O(1) — two integers |
