# 233. Number of Digit One — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-digit-one/

---

## Solution: Digit DP — O(log n) time, O(1) space

**Idea:** Count 1s contributed by each decimal position independently. For the digit at position `factor` (1, 10, 100, …):
- Let `higher = n / (factor * 10)`, `current = (n / factor) % 10`, `lower = n % factor`.
- If `current == 0`: count = `higher * factor`.
- If `current == 1`: count = `higher * factor + lower + 1`.
- If `current >= 2`: count = `(higher + 1) * factor`.

Sum over all positions.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — one pass per digit position |
| Space | O(1) |
