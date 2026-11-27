# 2244. Minimum Rounds to Complete All Tasks — Solution

## Approach

Count the frequency of each difficulty level. For each frequency:
- If `freq == 1`, it's impossible (return -1).
- Otherwise, greedily use as many rounds of 3 as possible:
  - `freq % 3 == 0` → `freq / 3` rounds
  - `freq % 3 == 1` → `(freq - 4) / 3 + 2` rounds (replace one triple with two pairs)
  - `freq % 3 == 2` → `freq / 3 + 1` rounds

This simplifies to: rounds = `ceil(freq / 3)` for `freq >= 2`.

## Complexity

- **Time:** O(n)
- **Space:** O(n) for the frequency map
