# 316. Remove Duplicate Letters — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/remove-duplicate-letters/

---

## Solution: Monotonic Stack + Last Occurrence — O(n) time, O(1) space

**Idea:** Maintain a monotonic stack. For each character, pop larger characters that still appear later in the string. Track characters already in the stack.

**Algorithm:**
1. Compute `last[c]` = last index of each character.
2. For each character: if in stack, skip. Otherwise pop larger chars with future occurrences.
3. Push current char.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
