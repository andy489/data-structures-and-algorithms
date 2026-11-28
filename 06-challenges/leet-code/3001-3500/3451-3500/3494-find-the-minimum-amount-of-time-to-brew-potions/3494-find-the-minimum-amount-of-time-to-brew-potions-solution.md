# 3494. Find the Minimum Amount of Time to Brew Potions — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/find-the-minimum-amount-of-time-to-brew-potions/

---

## Solution: Simulation with Earliest Start Time — O(n * m) time, O(n) space

**Idea:** For each potion `j`, simulate when each wizard can start and finish. Wizard `i` can start on potion `j` only after:
1. Wizard `i` finishes the previous potion `j-1`: `finish[i][j-1]`.
2. Wizard `i-1` finishes the current potion `j` (so it can be passed immediately): so wizard `i` must start at `finish[i-1][j] - skill[i-1] * mana[j]`... actually wizard `i` starts when wizard `i-1` finishes: `start[i][j] = finish[i-1][j]`.

We track `finish[i]` = time wizard `i` is done with the latest potion. For potion `j`, wizard 0 starts at `max(finish[0], start_j)` where `start_j` is the earliest start for the whole pipeline. We propagate forward: `start[i] = max(finish[i], finish[i-1])`, then update `finish[i] = start[i] + skill[i] * mana[j]`.

**Algorithm:**
1. Initialize `finish[0..n-1] = 0`.
2. For each potion `j`:
   - Wizard 0 can start at `finish[0]` earliest.
   - For each wizard `i` from 0 to n-1: `start = max(finish[i], (i > 0 ? finish[i-1] : 0))`, then `finish[i] = start + skill[i] * mana[j]`.
   - Actually for wizard 0, start = max(finish[0], earliest allowed by pipeline).
3. After processing all potions, return `finish[n-1]`.

**Complexity:**

| | |
|---|---|
| Time | O(n * m) |
| Space | O(n) |
