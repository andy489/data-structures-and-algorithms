# 420. Strong Password Checker — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/strong-password-checker/

---

## Solution: Greedy with Three Cases — O(n) time, O(n) space

**Idea:** Decompose requirements into three parts: length (too short / too long / in range), missing character types, and repeat runs. Handle each case:

- **Too short** (`n < 6`): Each insertion can simultaneously satisfy a missing type requirement. Steps = `max(6 - n, missingTypes)`.
- **Too long** (`n > 20`): Must delete `n - 20` characters. Each deletion within a run of length `k` reduces `floor(k/3)` needed replacements by 1 (delete 1 from 3k gives 1 fewer replace; from 3k+1 gives 1 fewer after 2 deletes; from 3k+2 gives 1 fewer after 3 deletes). Process greedily by run mod.
- **In range**: Steps = `max(replacements_needed, missingTypes)`.

**Algorithm:**
1. Scan to find: `missingTypes` (lacks upper/lower/digit), runs of 3+ repeated chars.
2. If `n < 6`: return `max(6 - n, missingTypes)`.
3. If `n > 20`: greedily use deletions to also reduce repeat replacements; then `steps = deletes + max(replacements_left, missingTypes)`.
4. If `6 <= n <= 20`: return `max(repeatReplacements, missingTypes)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — scanning and processing runs |
| Space | O(n) — storing run lengths |
