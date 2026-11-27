# 2125. Number of Laser Beams in a Bank — Solution

**Link:** https://leetcode.com/problems/number-of-laser-beams-in-a-bank/

## Approach: Multiply Consecutive Non-Empty Row Counts

Iterate through the rows. Skip rows with zero devices. For each pair of consecutive non-empty rows with counts `a` and `b`, add `a * b` to the answer.

The key insight: empty rows between two non-empty rows don't break the beam condition — they just mean both non-empty rows can see each other.

## Complexity

| | Time | Space |
|---|---|---|
| **Linear scan** | O(m * n) | O(1) |
