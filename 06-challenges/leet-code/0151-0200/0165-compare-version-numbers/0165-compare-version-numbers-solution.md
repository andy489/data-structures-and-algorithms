# 165. Compare Version Numbers — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/compare-version-numbers/

---

## Solution: Two-Pointer Split — O(n+m) time, O(n+m) space

**Idea:** Split both strings on `'.'`, then compare revision values integer by integer, padding the shorter one with 0s.

**Complexity:**

| | |
|---|---|
| Time | O(n + m) |
| Space | O(n + m) — split arrays |

---

## Solution 2: Two-Pointer Without Split — O(n+m) time, O(1) space

**Idea:** Walk both strings simultaneously, parsing each revision's integer value character by character. No array allocation needed.

**Complexity:**

| | |
|---|---|
| Time | O(n + m) |
| Space | O(1) |
