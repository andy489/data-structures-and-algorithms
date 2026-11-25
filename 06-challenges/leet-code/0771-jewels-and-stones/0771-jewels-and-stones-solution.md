# 771. Jewels and Stones — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/jewels-and-stones/

---

## Solution: Hash Set — O(j + s) time, O(j) space

**Idea:** Store all jewel types in a hash set, then count stones that appear in it.

**Algorithm:**
1. Add all characters of `jewels` to a set.
2. Count characters in `stones` that are in the set.

**Complexity:**

| | |
|---|---|
| Time | O(j + s) — j = jewels length, s = stones length |
| Space | O(j) — set of jewel characters |
