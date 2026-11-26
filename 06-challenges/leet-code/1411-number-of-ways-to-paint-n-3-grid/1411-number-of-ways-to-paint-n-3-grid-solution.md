# 1411. Number Of Ways To Paint N 3 Grid — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/

---

## Solution: Pattern Count DP — O(n) time, O(1) space

**Idea:** Any valid row is either 'ABA' pattern (3*2*2=12 colorings, e.g. 121) or 'ABC' pattern (3*2*1=6 colorings, e.g. 123). Track counts of each type between rows.

**Algorithm:**
1. Row 1: aba=12, abc=6.
2. Transition: aba_new = 3*aba + 2*abc, abc_new = 2*aba + 2*abc.
3. Return (aba + abc) % MOD after n steps.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
