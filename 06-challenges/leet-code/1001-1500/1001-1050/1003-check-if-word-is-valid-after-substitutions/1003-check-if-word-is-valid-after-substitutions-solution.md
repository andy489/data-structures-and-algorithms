# 1003. Check If Word Is Valid After Substitutions — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/

---

## Solution: Stack — O(n) time, O(n) space

**Idea:** Simulate the reverse process using a stack. For each character: if 'a', push 'a'; if 'b', top must be 'a', replace; if 'c', top must be 'b' (and second must be 'a'), pop both.

**Algorithm:**
1. For each char in s: push 'a' if 'a'; if 'b', check top=='a' then push 'b'; if 'c', check top=='b' and next=='a' then pop both.
2. Stack should be empty at the end.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
