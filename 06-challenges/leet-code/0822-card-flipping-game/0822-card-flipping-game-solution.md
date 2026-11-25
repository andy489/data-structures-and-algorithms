# 822. Card Flipping Game — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/card-flipping-game/

---

## Solution: Set of Same-Face Cards — O(n) time, O(n) space

**Idea:** A number is "bad" (can't be chosen) if it appears on both front and back of the same card (can't flip it away). Otherwise, any number appearing only on a back can be chosen. Find the minimum such number.

**Algorithm:**
1. Collect all numbers where fronts[i] == backs[i] into a "same" set.
2. For each card where fronts[i] != backs[i], consider backs[i] as a candidate (it can be hidden by flipping).
3. Return minimum candidate not in same set, or 0.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two passes |
| Space | O(n) — same set |
