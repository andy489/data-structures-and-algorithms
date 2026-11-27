# 917. Reverse Only Letters — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/reverse-only-letters/

---

## Solution: Two Pointers — O(n) time, O(n) space

**Idea:** Use two pointers from both ends, skipping non-letters, and swap letters.

**Algorithm:**
1. Convert to char array.
2. `left` moves right skipping non-letters; `right` moves left skipping non-letters.
3. Swap letters until pointers meet.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — char array |
